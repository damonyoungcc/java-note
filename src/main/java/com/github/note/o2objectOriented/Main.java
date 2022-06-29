package com.github.note.o2objectOriented;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(11);
        System.out.println(person.getAge());
        person.setName("张三");
        System.out.println(person.getName());
        person.setGender(true);
        System.out.println(person.isMale());
    }
}
