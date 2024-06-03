package com.mason.practice.boot330.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DatetimeConvertor {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime convert(String datetime, ZoneId fromZoneId, ZoneId tobeZoneId) {
        return LocalDateTime.parse(datetime).atZone(fromZoneId).withZoneSameInstant(tobeZoneId).toLocalDateTime();
    }

    public static LocalDateTime convert(LocalDateTime datetime, ZoneId fromZoneId, ZoneId tobeZoneId) {
        return datetime.atZone(fromZoneId).withZoneSameInstant(tobeZoneId).toLocalDateTime();
    }

    public static LocalDateTime convert(LocalDateTime datetime, String fromZoneId, String tobeZoneId) {
        return convert(datetime, ZoneId.of(fromZoneId), ZoneId.of(tobeZoneId));
    }

    public static LocalDateTime convert(LocalDateTime datetime, String tobeZoneId) {
        return convert(datetime, ZoneId.of("Asia/Seoul"), ZoneId.of(tobeZoneId));
    }

    public static String toStringDatetime(LocalDateTime dateTime) {
        return toStringDatetime(dateTime, "Asia/Seoul", "Asia/Seoul");
    }

    public static String toStringDatetime(LocalDateTime dateTime, String tobeZoneId) {
        return toStringDatetime(dateTime, "Asia/Seoul", tobeZoneId);
    }

    public static String toStringDatetime(LocalDateTime dateTime, String fromZoneId, String tobeZoneId) {
        return dateTime.atZone(ZoneId.of(fromZoneId)).withZoneSameInstant(ZoneId.of(tobeZoneId)).format(formatter);
    }
}
