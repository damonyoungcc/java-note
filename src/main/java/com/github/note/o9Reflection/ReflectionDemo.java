package com.github.note.o9Reflection;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(getClassInstance1() == getClassInstance2());
        System.out.println(getClassInstance1() == getClassInstance3());
        compareInstanceOf();
    }

    static Class getClassInstance1() {
        Class cls = String.class;
        return cls;
    }

    static Class getClassInstance2() {
        String s = "Hello World";
        Class cls = s.getClass();
        return cls;
    }

    static Class getClassInstance3() throws ClassNotFoundException {
        Class cls = Class.forName("java.lang.String");
        return cls;
    }

    static void compareInstanceOf() {
        Integer n = new Integer(123);
        System.out.println(n instanceof Integer);
        System.out.println(n instanceof Number);

        System.out.println(n.getClass() == Integer.class);
        //        System.out.println(n.getClass() == Number.class);
    }
}
