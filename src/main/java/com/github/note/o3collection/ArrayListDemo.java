package com.github.note.o3collection;

import java.util.*;

public class ArrayListDemo {

    static List<Integer> list = new ArrayList();
    static Collection<Integer> collection = new ArrayList<>();

    public static void main(String[] args) {
        createArrayList();
        handleArrayList();
        forEachArrayList();
        shiftToArray();
        shiftToArrayList();
    }

    // 公共打印函数
    static void printArrayList(List list) {
        System.out.println(Arrays.toString(list.toArray()));
    }

    // ArrayList 实现了List接口
    static void createArrayList() {
        for (int i = 0; i < 10; i++) {
            // 使用add往List中添加元素
            list.add(i);
        }
        System.out.println(Arrays.toString(list.toArray()));
        for (int i = 10; i < 20; i++) {
            collection.add(i);
        }
    }


    static void handleArrayList() {
        // 增
        list.add(10);
        printArrayList(list);
        // 指定位置索引添加一个元素
        list.add(0, -1);
        printArrayList(list);
        // 删除指定索引的元素
        list.remove(list.size() - 1);
        printArrayList(list);
        // 删除某个元素
        list.remove(5);
        printArrayList(list);
        // 获取指定索引的元素
        System.out.println(list.get(list.size() - 1));

        // 添加一整个
        list.addAll(collection);
        printArrayList(list);
    }

    // 遍历list
    static void forEachArrayList() {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------");
        // 使用迭代器
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            Integer i = it.next();
            System.out.println(i);
        }

        // 只要实现了Iterable 接口的集合类，都可以直接使用 for Each循环来遍历，自动变成Iterator 的调用
        System.out.println("----------------");

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    // List 和 Array转换
    static void shiftToArray() {
        // 这种方法会丢失类型信息
        System.out.println(Arrays.toString(list.toArray()));

        // 第二种方法 toArray(T[]), 这个T也可以不是Integer，也可以是Number
        Integer[] array = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(array));

    }

    static void shiftToArrayList() {
        Integer[] i = {1, 2, 3, 4, 5,};
        List list = Arrays.asList(i);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
