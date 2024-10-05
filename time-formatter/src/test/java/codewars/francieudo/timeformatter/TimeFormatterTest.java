package codewars.francieudo.timeformatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TimeFormatterTest {

    @Test
    public void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }

    @Test
    public void exampleTeststream() {
        assertEquals("1 second", TimeFormatter.formatDurationStrem(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDurationStrem(62));
        assertEquals("2 minutes", TimeFormatter.formatDurationStrem(120));
        assertEquals("1 hour", TimeFormatter.formatDurationStrem(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDurationStrem(3662));
    }
}
