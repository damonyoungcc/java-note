package com.github.note.o9Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class getFieldDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Student> stdClass = Student.class;
        System.out.println(stdClass.getField("score"));
        System.out.println(stdClass.getField("name"));
        System.out.println(stdClass.getDeclaredField("grade"));
        System.out.println(Arrays.toString(stdClass.getFields())); // 返回的是一个数组

        Field f = stdClass.getField("score");
        System.out.println(f.getName());
        System.out.println(f.getType());
        int m = f.getModifiers();
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isProtected(m));
        System.out.println(Modifier.isPrivate(m));
        System.out.println(Modifier.isStatic(m));

        // 获取字段的值
        Object p = new Animal("小明");
        Class c = p.getClass();
        Field f1 = c.getDeclaredField("name");
        f1.setAccessible(true);
        Object value = f1.get(p);
        System.out.println(value);
    }

    static class Student extends Person {
        public int score;
        private int grade;
    }

    static class Person {
        public String name;
    }

    static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }
    }
}
