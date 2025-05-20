package com.shinhan.home.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParseUtil {
	
    // 포맷 지정
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * LocalDateTime -> yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.format(DATETIME_FORMATTER);
    }

    /**
     * yyyy-MM-dd HH:mm:ss -> LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isBlank()) return null;
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    /**
     * LocalDate -> yyyy-MM-dd
     */
    public static String formatDate(LocalDate date) {
        if (date == null) return null;
        return date.format(DATE_FORMATTER);
    }

    /**
     * yyyy-MM-dd -> LocalDate
     */
    public static LocalDate parseDate(String dateStr) {
        if (dateStr == null || dateStr.isBlank()) return null;
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }
    
    /**
     * String -> Integer
     */
    public static Integer parseInt(String str) {
        try {
            return (str == null || str.isBlank()) ? null : Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static Long parseLong (String str) {
        try {
            return (str == null || str.isBlank()) ? null : Long.parseLong(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
