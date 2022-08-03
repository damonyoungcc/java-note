package com.github.note.o9Reflection;

import java.util.Collections;

public class GetClassInfo {
    public static void main(String[] args) {
        printClassInfo("".getClass());
        System.out.println("---------------");
        printClassInfo(Runnable.class);
        System.out.println("---------------");
        printClassInfo(java.time.Month.class);
        System.out.println("---------------");
        printClassInfo(String[].class);
        System.out.println("---------------");
        printClassInfo(int.class);
        System.out.println("---------------");
        printClassInfo(Collections.emptyList().getClass());
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is Interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
