package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

public class Food {
    private int x;
    private int y;

    public Food(int boardSize){
        randomizePos(boardSize);

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void randomizePos(int boardSize){
        x = MathUtils.random(boardSize - 1);
        y = MathUtils.random(boardSize - 1);

    }
}
