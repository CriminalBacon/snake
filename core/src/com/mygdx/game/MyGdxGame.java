package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	SpriteBatch batch;

	int x = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		this.setScreen(new GameScreen(this));

	}

	@Override
	public void render () {

		super.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
