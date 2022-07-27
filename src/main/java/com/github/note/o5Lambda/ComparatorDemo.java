package com.github.note.o5Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    static Integer[] array = {10, 2, 31, 4};
    static Integer[] array1 = {1, 5, 4, 3};
    static Integer[] array2 = {1, 5, 14, 3};
    static Integer[] array3 = {1, 15, 4, 3};

    public static void main(String[] args) {
        sort();
        sortByLambda();
        sortByLambda1();
        sortByLambda2();
    }

    // 匿名类的方式编写
    static void sort() {
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(Arrays.toString(array));
    }

    // 使用Lambda方式编写
    static void sortByLambda() {
        Arrays.sort(array1, (s1, s2) -> s1.compareTo(s2));
        System.out.println(Arrays.toString(array1));
    }

    // 使用方法引用
    static void sortByLambda1() {
        Arrays.sort(array2, Integer::compareTo);
        System.out.println(Arrays.toString(array2));
    }

    // 使用方法引用
    static void sortByLambda2() {
        Arrays.sort(array3, Comparator.reverseOrder());
        System.out.println(Arrays.toString(array3));
    }
}
