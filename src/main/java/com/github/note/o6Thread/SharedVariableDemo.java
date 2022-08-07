package com.github.note.o6Thread;

public class SharedVariableDemo {
    private static int i = 0;

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            new Thread(SharedVariableDemo::modifySharedVariable).start();
        }
        long t1 = System.currentTimeMillis();
        System.out.println("耗时： " + (t1 - t0) + " ms");
    }

    private static void modifySharedVariable() {
        // 不是一个原子操作
        // 取 i 的值
        // 把 i 的值加1
        // 把修改后的值写回 i
        i++;
        System.out.println("i: " + i);
    }
}
