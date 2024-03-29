/**
 * 方法的重载，构造方法的重载
 */
package com.github.note.o2objectOriented;

public class ReloadMethod {
    int age = 2;
    String name = " ";

    // 创建一直默认的猫，1岁，名字叫张三
    ReloadMethod() {
        this("张三");
    }

    // 创建一只默认的猫，1岁，名字叫name指定的名字
    ReloadMethod(String name) {
        this(1, name);
    }

    // 创建age和name指定的猫
    public ReloadMethod(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public void meow() {
        System.out.println("喵!" + "I'm " + this.name + " and I'm " + this.age);
    }

    public static void main(String[] args) {
        ReloadMethod c = new ReloadMethod();
        System.out.println(c.name);
        System.out.println(c.age);
        c.meow();
    }
}
