package com.github.note.o3collection;

import java.util.HashMap;
import java.util.Map;

public class mapDemo {
    static Map<Integer, Student> map = new HashMap<>();

    public static void main(String[] args) {
        baseDemo();
        forEachMapKey();
    }

    static void baseDemo() {
        for (int i = 0; i < 10; i++) {
            map.put(i, new Student(i + 10, "哈哈哈"));
        }
        System.out.println(map.get(0));
        System.out.println(map.get(100)); // 不存在就返回null
    }

    // 遍历Map
    static void forEachMapKey() {
        // map.keySet()可以获取map中不重复的key，结果是一个Set集合
        for (Integer i : map.keySet()) {
            System.out.println(i);
        }

        System.out.println("-----------------");

        // 遍历map的key和value
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Student student = entry.getValue();
            System.out.println(key + ": " + student);
        }
    }

    /**
     *  1. 作为 key 的对象必须正确覆写 equals() 方法，相等的两个 key 实例调用 equals() 必须返回 true
     *  2. 作为 key 的对象还必须正确覆写 hashCode() 方法
     */
}

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}