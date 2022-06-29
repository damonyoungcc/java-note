/**
 * 封装
 * 访问控制符 protected 是包级私有的，只有在同一个包中才可以访问
 * 包是没有嵌套关系的
 *
 */


package com.github.note.o2objectOriented;

import java.util.Objects;

public class Person {

    protected String name;
    private int age;
    // gender true 代表男的，false代表女的
    // 需求改变后，如果不做封装，直接访问，则不可扩展
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return Objects.equals(gender, "M");
    }

    @Deprecated
    public void setGender(boolean gender) {
        this.gender = gender ? "M" : "F";
    }
}
