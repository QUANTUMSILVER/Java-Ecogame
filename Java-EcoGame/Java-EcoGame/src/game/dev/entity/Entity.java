package game.dev.entity;

import java.awt.Graphics;

import game.dev.Handler;

public abstract class Entity {
	
	protected int CREATURE_WIDTH = 20, CREATURE_HEIGHT = 20;
	
	protected Handler handler;
	protected float x, y;
	
	public Entity(Handler handler, float x, float y) {
		this.handler = handler;
		this.x = x;
		this.y = y;
	}

	public abstract void update();
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public int getWidth() {
		return CREATURE_WIDTH;
	}

	public int getHeight() {
		return CREATURE_HEIGHT;
	}
	
}
