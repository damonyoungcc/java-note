package com.github.note.o2objectOriented.fileDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileFilter {
    public static void main(String[] args) throws IOException {
        Path projectDir = Paths.get(System.getProperty("user.dir"));
        Path testRootDir = projectDir.resolve(".idea");
        if (!testRootDir.toFile().isDirectory()) {
            throw new IllegalStateException(
                    testRootDir.toAbsolutePath() + "不存在！");
        }

        List<String> filteredFileNames = filter(testRootDir, ".xml");
        System.out.println(filteredFileNames);
    }


    public static List<String> filter(Path rootDirectory, String extension) throws IOException {
        FileFilterVisitor visitor = new FileFilterVisitor(extension);

        Files.walkFileTree(rootDirectory, visitor);
        return visitor.getFilteredNames();
    }
}
