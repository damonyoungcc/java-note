package com.github.note.o6Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadMapDemo {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(ThreadMapDemo::putIfAbsent).start();
        }
    }

    private static void putIfAbsent() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int r = new Random().nextInt(10);
        if (!map.containsKey(r)) {
            map.put(r, r);
            System.out.println("put " + r);
        }
    }
}
