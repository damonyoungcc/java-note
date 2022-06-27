package com.github.note.o2objectOriented;

public class Home {
    Cat cat;

    public Home(Cat cat) {
        this.cat = cat;
    }

    public static void main(String[] args) {
        // 1、划分一块内存 2、初始化 3、调用构造器
        new Cat(1, "mimi");
    }
}
