package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;


public class GameState {

    private int boardSize = 30;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private int yOffset = 400;
    private Queue<Bodypart> body = new Queue<>();
    private float timer = 0;
    private Controls controls = new Controls();
    private Food food = new Food(boardSize);
    private int snakeLenght = 3;
    

    public GameState(){
        //head
        body.addLast(new Bodypart(15, 15, boardSize));

        body.addLast(new Bodypart(15, 14, boardSize));

        //tail
        body.addLast(new Bodypart(15, 13, boardSize));

    }

    public void update(float delta){
        timer += delta;

        // limits speed of snake
        if(timer > 0.13f){
            timer = 0;
            advance();
        }

        controls.update();

    }

    private void advance() {
        int headX = body.first().getX();
        int headY = body.first().getY();

        switch (controls.getDirection()){
            case 0: //UP
                body.addFirst(new Bodypart(headX, headY + 1, boardSize));
                break;
            case 1: //RIGHT
                body.addFirst(new Bodypart(headX + 1, headY, boardSize));
                break;
            case 2: //DOWN
                body.addFirst(new Bodypart(headX, headY - 1, boardSize));
                break;
            case 3: //LEFT
                body.addFirst(new Bodypart(headX - 1, headY, boardSize));
                break;

        }

        // if snake eats food, grow length and create another food
        if (body.first().getX() == food.getX() && body.first().getY() == food.getY()){
            snakeLenght++;
            food.randomizePos(boardSize);

        }

        if (body.size - 1 == snakeLenght){
            body.removeLast();
        }

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
        for (Bodypart bp : body){
            shapeRenderer.rect(bp.getX()*scaleSnake, bp.getY()*scaleSnake + yOffset, scaleSnake, scaleSnake);
        }

        // food
        shapeRenderer.setColor(0, 1,0 , 1);
        shapeRenderer.rect(food.getX() * scaleSnake, food.getY() * scaleSnake + yOffset, scaleSnake, scaleSnake);


        shapeRenderer.end();
    }

}
