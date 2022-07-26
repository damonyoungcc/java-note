package com.github.note.o2objectOriented.fileDemo;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileFilterVisitor extends SimpleFileVisitor<Path> {
    private String extension;
    private List<String> filteredNames = new ArrayList<>();

    public FileFilterVisitor(String extension) {
        this.extension = extension;
    }

    public List<String> getFilteredNames() {
        return filteredNames;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith(this.extension)) {
            filteredNames.add(file.getFileName().toString());
        }
        return FileVisitResult.CONTINUE;
    }
}
