package functional.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class TestUtils {

    public static String getTodayDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        return formatter.format(dateTime);
    }

    public static String getTomorrowDate() {
        LocalDateTime dateTime = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        return formatter.format(dateTime);
    }

    public static String getThisWeekDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        DayOfWeek weekStart = DayOfWeek.MONDAY;
        dateTime = dateTime.with(TemporalAdjusters.previousOrSame(weekStart));
        return formatter.format(dateTime);
    }

    public static String getNextWeekDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        DayOfWeek weekStart = DayOfWeek.MONDAY;
        dateTime = dateTime.with(TemporalAdjusters.nextOrSame(weekStart));
        return formatter.format(dateTime);
    }

    public static String getThisMonthDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        dateTime = dateTime.with(TemporalAdjusters.firstDayOfMonth());
        return formatter.format(dateTime);
    }

    public static String getNextMonthDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        dateTime = dateTime.with(TemporalAdjusters.firstDayOfNextMonth());
        return formatter.format(dateTime);
    }
}