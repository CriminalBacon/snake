package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;


public class GameState {

    private int boardSize = 30;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private int yOffset = 400;
    private Queue<Bodypart> mBody = new Queue<>();
    private float mTimer = 0;
    private Controls controls = new Controls();
    

    public GameState(){
        //head
        mBody.addLast(new Bodypart(15, 15, boardSize));

        mBody.addLast(new Bodypart(15, 14, boardSize));

        //tail
        mBody.addLast(new Bodypart(15, 13, boardSize));

    }

    public void update(float delta){
        mTimer += delta;

        // limits speed of snake
        if(mTimer > 0.13f){
            mTimer = 0;
            advance();
        }

        controls.update();

    }

    private void advance() {
        int headX = mBody.first().getX();
        int headY = mBody.first().getY();

        switch (controls.getDirection()){
            case 0: //UP
                mBody.addFirst(new Bodypart(headX, headY + 1, boardSize));
                break;
            case 1: //RIGHT
                mBody.addFirst(new Bodypart(headX + 1, headY, boardSize));
                break;
            case 2: //DOWN
                mBody.addFirst(new Bodypart(headX, headY - 1, boardSize));
                break;
            case 3: //LEFT
                mBody.addFirst(new Bodypart(headX - 1, headY, boardSize));
                break;

        }

        mBody.removeLast();

    }

    public void draw(int width, int height, OrthographicCamera camera){
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // rectangle drawing happens here

        // game board
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(0, yOffset, width, height);

        // game board boarder
        shapeRenderer.setColor(0, 0,0 , 1);
        shapeRenderer.rect(0+5, yOffset + 5, width-5*2, width-5*2);

        // snake
        float scaleSnake = width/boardSize;
        shapeRenderer.setColor(1, 0,0 , 1);
        for (Bodypart bp : mBody){
            shapeRenderer.rect(bp.getX()*scaleSnake, bp.getY()*scaleSnake + yOffset, scaleSnake, scaleSnake);
        }


        shapeRenderer.end();
    }

}
