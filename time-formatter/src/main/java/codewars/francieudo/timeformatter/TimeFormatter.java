package codewars.francieudo.timeformatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TimeFormatter {

    public static String formatDuration(int seconds){

        List<String> stringTimeFormat = new ArrayList<>();

        int ano = seconds / (365*24*60*60);
        int modSegundos = seconds %  (365*24*60*60);

        int dias = modSegundos / (24*60*60);
        modSegundos = modSegundos % (24*60*60);

        int horas = modSegundos/ (60 * 60);
        modSegundos = modSegundos % (60 *60);

        int minutos = modSegundos / 60;
        int segundos = modSegundos % 60;

        stringTimeFormat.add(formatYear(ano));
        stringTimeFormat.add(formatDay(dias));
        stringTimeFormat.add(formateHours(horas));
        stringTimeFormat.add(formatMinute(minutos));
        stringTimeFormat.add(formatSecond(segundos));

        stringTimeFormat.removeIf(String::isBlank);

        return formatString(stringTimeFormat);
    }

    public static String formatString(List<String> stringFormat){

        if(stringFormat.isEmpty()){
            return "now";
        }else if(stringFormat.size() == 1){
            return stringFormat.get(0);
        }else if(stringFormat.size() == 2){
            return String.join(" and ", stringFormat);
        }else{
            String formated = String.join(", ", stringFormat.subList(0, stringFormat.size()-1));
            return formated + " and " + stringFormat.get(stringFormat.size() -1);
        }
    }

    public static String formateHours(int hours){

        return hours <= 0 ? "" : hours == 1 ? "1 hour" : "" + hours + " hours";
    }

    public static String formatMinute(int minute){

        return minute <=0 ? "" : minute == 1 ? "1 minute" : "" + minute + " minutes";
    }

    public static String formatSecond(int second){

        return second <=0 ? "" : second == 1 ? "1 second" : "" + second + " seconds";
    }

    public static String formatYear(int year){

        return year <=0 ? "" : year == 1 ? "1 year" : "" + year + " years";
    }

    public static String formatDay(int day){

        return day <=0 ? "" : day == 1 ? "1 day" : "" + day + " days";
    }

    /*
     * Metódo usando stream api
     */

     public static String formatDurationStrem(int seconds){

        return seconds == 0 ? "now" :
            Arrays.stream(
                new String[]{
                    formatTime("year", (seconds / 31536000)),
                    formatTime("day", (seconds/ 86400) % 365),
                    formatTime("hour", (seconds/3600) % 24),
                    formatTime("minute", (seconds/60) %60),
                    formatTime("second", (seconds%3600)%60)
                }
            ).filter(v -> v!="")
            .collect(Collectors.joining(", "))
            .replaceAll(", (?!.+,)", " and ");
     }

     public static String formatTime(String s, int time){
        return time ==0 ? "" : Integer.toString(time) + " " + s + (time ==1 ? "" : "s" );
     }
}
