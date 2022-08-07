package com.github.note.o6Thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Crawler {
    // 静态变量 类变量是被所有线程共享的
    private static int i;

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        // start 方法可以开始执行一个新的线程
        new Thread(Crawler::slowFileOperation).start();
        new Thread(Crawler::slowFileOperation).start();
        new Thread(Crawler::slowFileOperation).start();
        slowFileOperation();
        long t1 = System.currentTimeMillis();
        System.out.println("耗时: " + (t1 - t0) + "ms");
    }

    private static void slowFileOperation() {
        i += 1;
        System.out.println("i is " + i);
        try {
            File tmp = File.createTempFile("tmp", "");
            for (int i = 0; i < 10000; i++) {
                try (FileOutputStream fos = new FileOutputStream(tmp)) {
                    fos.write(i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
