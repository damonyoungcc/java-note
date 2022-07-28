package com.github.note.o5Lambda;

import java.util.stream.Stream;

public class streamReduce {

    public static void main(String[] args) {
        sum();
        multiply();
    }

    static void sum() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = stream.reduce(0, (acc, n) -> acc + n);
        System.out.println(sum);
    }

    static void multiply() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = stream.reduce(1, (mul, n) -> mul * n);
        System.out.println(result);
    }

}
