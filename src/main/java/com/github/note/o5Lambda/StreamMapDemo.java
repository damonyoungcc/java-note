package com.github.note.o5Lambda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class StreamMapDemo {
    public static void main(String[] args) {
        mapString();
        streamFilter();
        filterWorkDay();
    }

    static void mapString() {
        List<String> list = Arrays.asList(" Apple ", " Mac ", " AppleWatch");
        list.stream().map(String::trim).map(String::toLowerCase).forEach(System.out::println);
    }

    static void streamFilter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
    }

    static void filterWorkDay() {
        Stream.generate(new LocalDateSupplier()).limit(31).filter(
                ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY).forEach(
                System.out::println);
    }

    static class LocalDateSupplier implements Supplier<LocalDate> {
        LocalDate start = LocalDate.of(2022, 7, 27);
        int n = -1;

        @Override
        public LocalDate get() {
            n++;
            return start.plusDays(n);
        }
    }
}


