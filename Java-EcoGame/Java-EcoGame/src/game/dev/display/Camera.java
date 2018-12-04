package game.dev.display;

import game.dev.Handler;
import game.dev.entity.Entity;

public class Camera {
	
	private Handler handler;
	private float xoff, yoff;
	
	public Camera(Handler handler, int x, int y) {
		this.handler = handler;
		this.xoff = x;
		this.yoff = y;
	}
	
	public void focusEntity(Entity e) {
		xoff = e.getX()-handler.getWidth()/2 + e.getWidth()/2;
		yoff = e.getY()-handler.getHeight()/2 + e.getHeight()/2;
	}
	
	public void move(float x, float y) {
		xoff += x;
		yoff += y;
	}
	
	public float getXoff() {
		return xoff;
	}

	public void setXoff(float xoff) {
		this.xoff = xoff;
	}

	public float getYoff() {
		return yoff;
	}

	public void setYoff(float yoff) {
		this.yoff = yoff;
	}
	
}
