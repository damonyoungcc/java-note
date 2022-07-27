package com.github.note.o4Exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ExceptionDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String[] s = {"1", "2"};
        TryCatchDemo.main(s);
        ThrowExceptionDemo.main(s);
    }
}

class TryCatchDemo {
    final private static String s = "中文";

    public static void main(String[] args) {
        byte[] bs = toGBK();
        System.out.println(Arrays.toString(bs));
    }

    // toGBK 内部消化异常
    static byte[] toGBK() {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); // 打印异常栈
            return s.getBytes();
        }
    }
}

class ThrowExceptionDemo {
    final private static String s = "中文";

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bs = toGBK();
        System.out.println(Arrays.toString(bs));
    }

    static byte[] toGBK() throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }
}