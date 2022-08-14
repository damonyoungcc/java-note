package com.github.note.o10Annotation;

public class MyService {
    @Log
    public void queryDatabase(int param) {
        System.out.println("query db: " + param);
    }

    @Log
    public void provideHttpService(String param) {
        System.out.println("provide http service: " + param);
    }

    public void noLog() {
        System.out.println("no log");
    }
}
