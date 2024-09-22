package codewars.francieudo.mean;

import java.util.stream.IntStream;

public class Solution {

    public static double solution(int[] arr1, int[] arr2){

        if(arr1.length != arr2.length){
            return -1;
        }

        double soma = 0;

        for(int i=0; i<arr1.length; i++){

            soma += Math.pow(arr1[i] - arr2[i], 2);
        }

        return soma/arr1.length;
    }

    public static double solutionComStreamApi(int[] arr1, int[] arr2){

        return IntStream.range(0, arr1.length)
                .map(i -> arr1[i] - arr2[i])
                .map(j -> j * j)
                .average().orElse(0);
    }
}

