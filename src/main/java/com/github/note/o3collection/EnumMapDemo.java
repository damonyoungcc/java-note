package com.github.note.o3collection;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        String[] weekArray = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY",
                "FRIDAY", "SATURDAY", "SUNDAY"};
        for (int i = 0; i < weekArray.length; i++) {
            map.put(DayOfWeek.of(i + 1),
                    "星期".concat(String.valueOf(i + 1)) + ": " + weekArray[i]);
        }
        System.out.println(map);
    }
}
