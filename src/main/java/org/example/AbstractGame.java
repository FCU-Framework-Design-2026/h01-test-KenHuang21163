package org.example;

public abstract class AbstractGame {
    abstract void setPlayers(String p1, String p2);
    abstract boolean gameOver();
    abstract boolean move(int location);
    abstract boolean move(int from, int to);
}