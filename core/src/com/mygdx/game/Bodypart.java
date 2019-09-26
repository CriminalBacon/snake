package com.mygdx.game;

public class Bodypart {
    private int x;
    private int y;


    public Bodypart(int x, int y, int boardSize){
        this.x = x % boardSize;
        if (this.x < 0) this.x += boardSize;

        this.y = y % boardSize;
        if (this.y < 0) this.y += boardSize;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
