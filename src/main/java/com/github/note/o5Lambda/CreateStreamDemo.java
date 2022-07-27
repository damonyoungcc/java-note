package com.github.note.o5Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) {
        createStreamByStreamOf();
        createStreamByArrayOrCollection();
        createStreamBySupplier();
        stringSplitToStream();
    }

    // 使用Stream.of() 创建 Stream
    static void createStreamByStreamOf() {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        stream.forEach(System.out::println);
        System.out.println("-------------");
    }

    // 基于数组或者Collection
    static void createStreamByArrayOrCollection() {
        Stream<String> stream1 = Arrays.stream(new String[]{"X", "Y", "Z"});

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "O", "P", "Q");
        Stream<String> stream2 = list.stream();

        stream1.forEach(System.out::println);
        System.out.println("-------------");
        stream2.forEach(System.out::println);
        System.out.println("-------------");
    }

    /**
     * 基于Supplier创建，下面Supplier<Integer>模拟了一个无限序列
     * 若用List表示，在int范围内会占用巨大的内存
     * Stream几乎不占空间，因为每个元素都是实时计算出来的，用的时候再算。
     */
    static void createStreamBySupplier() {
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        natual.limit(100).forEach(System.out::println);
    }

    // 正则表达式的API返回值是stream
    static void stringSplitToStream() {
        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("Hello World, Hello Java!");
        s.forEach(System.out::println);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;

    @Override
    public Integer get() {
        n++;
        return n;
    }
}