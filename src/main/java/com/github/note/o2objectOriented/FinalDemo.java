package com.github.note.o2objectOriented;

public class FinalDemo {
    public static void main(String[] args) {
        System.out.println(FinalWorld.getInstance());
    }
}


class FinalWorld {
    private int area = 96000;
    private String name = "China";
    private static final FinalWorld SINGLE_INSTANCE = new FinalWorld();

    public static FinalWorld getInstance() {
        return SINGLE_INSTANCE;
    }

    private FinalWorld() {
        this.area = area;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FinalWorld: {" +
                "area=" + area +
                ", name='" + name + '\'' +
                '}';
    }
}