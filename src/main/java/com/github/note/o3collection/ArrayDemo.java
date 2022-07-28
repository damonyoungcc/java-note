/**
 * 数组在初始化后大小不可变 数组只能按索引顺序存取
 */
package com.github.note.o3collection;

import java.util.Arrays;
import java.util.Collections;

public class ArrayDemo {
    public static void main(String[] args) {
        ArrayDemo.loop();
        System.out.println("---------------");
        forEach();
        System.out.println("---------------");
        printArray();
        System.out.println("---------------");
        sortArray();
        System.out.println("---------------");
        innerSort();
    }

    static void loop() {
        int[] ns = {1, 3, 5, 7, 9, 11};
        for (int i = 0; i < ns.length; i++) {
            System.out.print(ns[i]);
        }
    }

    static void forEach() {
        int[] ns = {2, 4, 6, 8, 10, 12};
        for (int n : ns) {
            System.out.print(n);
        }
    }

    // 打印数组的内容
    static void printArray() {
        int[] ns = {1, 2, 3, 4};
        System.out.println(ns); // 这时打印的是地址
        // 使用 Arrays.toString() 打印
        System.out.println(Arrays.toString(ns));
    }

    static void sortArray() {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j + 1]) {
                    int temp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ns));
    }

    static void innerSort() {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));
        Integer[] ns1 = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // Arrays.sort(T[], Comparator<? super T>): void
        Arrays.sort(ns1, Collections.reverseOrder()); // 降序排序
        System.out.println(Arrays.toString(ns1));
    }

}
