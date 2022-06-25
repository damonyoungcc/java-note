package com.github.note;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {

    public static void printOldNumber(int start, int end) {
        IntStream.range(start, end + 1).filter(i -> i % 2 != 0).mapToObj(i -> i + ",").forEach(System.out::print);
    }

    public static int findUpperCaseChar(String str) {
        return (int) (str.chars().filter(Character::isUpperCase).count());
    }

    // 是否有至少一个人姓李
    public static boolean anyMatchLiUser(List<User> users) {
        return users.stream().anyMatch(user -> user.getName().startsWith("李"));
    }

    // 是否没有一个人姓张
    public static boolean noneMatchLiUser(List<User> users) {
        return users.stream().noneMatch(user -> user.getName().startsWith("张"));
    }

    // 找到第一个姓张的人
    public static Optional<User> findFirstZhangUser(List<User> users) {
        return users.stream().filter(user -> user.getName().startsWith("张")).findFirst();
    }

    public static void main(String[] args) {
        printOldNumber(1, 100);
        System.out.println("----------");
        System.out.println(findUpperCaseChar("Hello World!"));
        System.out.println("----------");
        List<User> users = User.getUsers();
        System.out.println(anyMatchLiUser(users));
        System.out.println("----------");
        System.out.println(noneMatchLiUser(users));
        System.out.println("----------");
        System.out.println(findFirstZhangUser(users));
        System.out.println("----------");
    }

}
