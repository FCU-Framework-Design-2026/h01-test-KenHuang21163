package org.example;

public class Chess {
    String name;
    int weight;
    String side;
    boolean isOpened = false;

    public Chess(String name, int weight, String side) {
        this.name = name;
        this.weight = weight;
        this.side = side;
    }

    @Override
    public String toString() {
        if (!isOpened) return " Ｘ ";
        return (side.equals("紅")) ? " " + name + " " : "[" + name + "]";
    }
}