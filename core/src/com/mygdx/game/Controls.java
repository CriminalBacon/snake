package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controls {

    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private int currentDirection;
    private int nextDirection;

    public int getDirection(){
        currentDirection = nextDirection;
        return nextDirection;

    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && currentDirection != DOWN) nextDirection = 0;
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && currentDirection !=LEFT) nextDirection = 1;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && currentDirection != UP) nextDirection = 2;
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && currentDirection != RIGHT) nextDirection = 3;

    }



}
