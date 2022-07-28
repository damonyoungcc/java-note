package com.github.note.o5Lambda;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        stringToPerson();
    }

    static void stringToPerson() {
        List<String> list = Arrays.asList("Bob", "Alice", "Tim");
        list.stream().map(Person::new).forEach(System.out::println);
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + '}';
        }
    }

}


