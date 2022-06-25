package com.github.note;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User: [name= " + name + ",age= " + age + "]";
    }

    public static List<User> getUsers() {
        User user1 = new User("张一", 62);
        User user2 = new User("张2", 14);
        User user3 = new User("张3", 77);
        User user55 = new User("王5", 42);
        User user4 = new User("张4", 32);
        User user5 = new User("张5", 42);
        return Arrays.asList(user1, user2, user3, user4, user5, user55);
    }

    public static void main(String[] args) {

        // 1. 普通筛选排序
        List<User> users = getUsers();
        List<User> zhangUsers = new ArrayList<>();
        for (User user : users) {
            if (user.name.startsWith("张")) {
                zhangUsers.add(user);
            }
        }
        zhangUsers.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.age - o2.age > 0) {
                    return 1;
                } else if (o1.age - o2.age < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        List<String> names = new ArrayList<>();
        for (User user : zhangUsers) {
            names.add(user.name);
        }
        System.out.println(names);
        System.out.println("-------------");

        // 2. 函数式的筛选排序
        List<User> users1 = getUsers();
        users1.sort(Comparator.comparing(User::getAge));
        System.out.println(users1);
        System.out.println("-------------");

        // 3. 使用stream
        List<User> user2 = getUsers();
        // 一个流只能被消费一次，如果调用的方法（如collect）返回的不是流，则终结
        List<String> names1 = user2.stream().filter(user -> user.name.startsWith("张"))
                .sorted(Comparator.comparing(User::getAge)).map(User::getName).collect(Collectors.toList());
        System.out.println(names1);
    }

}
