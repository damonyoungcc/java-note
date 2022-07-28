package com.github.note.o6Thread;

public class ThreadSleep {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Thread end.");
                }
            }
        };
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
        System.out.println("main end...");
    }
}
