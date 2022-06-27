package com.github.note.o2objectOriented;

public class Cat {
    int age = 2;
    String name = " ";

    public Cat(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public void meow() {
        System.out.println("喵" + "I'm " + this.name + " and I'm " + this.age);
    }
}
