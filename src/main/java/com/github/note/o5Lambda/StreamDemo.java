package com.github.note.o5Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        stringToPerson();
    }

    static void stringToPerson() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Bob", "Alice", "Tim");
        List<Person> persons = list.stream().map(Person::new).collect(Collectors.toList());
        for (Person p : persons) {
            System.out.println(p);
        }
    }

}


class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}