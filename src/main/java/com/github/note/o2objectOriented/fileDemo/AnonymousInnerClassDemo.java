package com.github.note.o2objectOriented.fileDemo;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class AnonymousInnerClassDemo {
    public static void main(String[] args) throws IOException {
        Path projectDir = Paths.get(System.getProperty("user.dir"));
        Path testRootDir = projectDir.resolve(".idea");
        if (!testRootDir.toFile().isDirectory()) {
            throw new IllegalStateException(testRootDir.toAbsolutePath().toString() + "不存在！");
        }
        System.out.println(filter(testRootDir, ".xml"));

    }

    public static List<String> filter(Path rootDirectory, String extension) throws IOException {
        List<String> names = new ArrayList<>();
        Files.walkFileTree(rootDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().endsWith(extension)) {
                    names.add(file.getFileName().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return names;
    }
}
