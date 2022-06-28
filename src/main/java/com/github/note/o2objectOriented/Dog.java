/**
 * 对象的初始化顺序
 */
package com.github.note.o2objectOriented;

public class Dog {
    // 1、静态成员初始化
    static int a = 123;


    // 2、静态初始化块执行
    static {
        for (int i = 0; i < 100; i++) {
            a += i;
        }
        //f();// 这里不可以调用成员方法f，因为static是属于类的
    }


    // 3、成员初始化
    int age = 1;
    String name = "张三";

    // 4、初始化块执行
    {
        for (int i = 0; i < 100; i++) {
            age += i;
        }
        // 这里可以调用成员方法
        f();
    }

    // 5、 执行构造函数
    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    Dog() {
        this.name = name;
        this.age = age;
    }

    void f() {
    }

    public static void main(String[] args) {
        new Dog(2, "ABC");
        new Dog();
    }


}
