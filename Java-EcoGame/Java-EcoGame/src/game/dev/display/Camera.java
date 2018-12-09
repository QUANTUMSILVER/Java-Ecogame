package game.dev.display;

import java.awt.event.KeyEvent;

import game.dev.Handler;
import game.dev.entity.Entity;
import game.dev.tile.Tile;

public class Camera {
	
	@SuppressWarnings("unused")
	private float cameraSpring = 15;
	
	private Handler handler;
	
	public float velx = 0, vely = 0;
	
	private float xoff, yoff;
	
	public Camera(Handler handler, int x, int y) {
		this.handler = handler;
		this.xoff = x;
		this.yoff = y;
	}
	public void moveCamera() {
		float maxCameraSpeed = 3;
		double deacc = 0.95;
		
		if(handler.getKeyManager().getKey(KeyEvent.VK_W)) {
			vely = -maxCameraSpeed;
		}else if(handler.getKeyManager().getKey(KeyEvent.VK_S)) {
			vely = maxCameraSpeed;
		}if(handler.getKeyManager().getKey(KeyEvent.VK_A)) {
			velx = -maxCameraSpeed;
		}else if(handler.getKeyManager().getKey(KeyEvent.VK_D)) {
			velx = maxCameraSpeed;
		}
		
		float mag = (float) Math.sqrt(velx*velx + vely*vely);
		
		if (mag != 0) {
			move(velx * Math.abs(velx/mag), vely * Math.abs(vely/mag));
		}
		
		velx *= deacc;
		vely *= deacc;
	}
	public void focusPosition(float x, float y) {
	
		float setX = x-handler.getWidth()/2;
		float setY = y-handler.getHeight()/2;
		move((setX-xoff), (setY-yoff));
		
	}
	
	public void focusEntity(Entity e) {
		
		float setX = e.getX()-handler.getWidth()/2 + e.getWidth()/2;
		float setY = e.getY()-handler.getHeight()/2 + e.getHeight()/2;
		move((setX-xoff),(setY-yoff));
		
	}
	

	
	public void move(float x, float y) {
		xoff += x;
		yoff += y;
		if (xoff<0) {
			xoff = 0;
		}
		if (yoff<0) {
			yoff = 0;
		}
		if (xoff>handler.getWorld().getMapWidth()*Tile.TILE_WIDTH-handler.getWidth()) {
			xoff = (float) (handler.getWorld().getMapWidth()*Tile.TILE_WIDTH-handler.getWidth());
		}
		if (yoff>handler.getWorld().getMapHeight()*Tile.TILE_HEIGHT-handler.getHeight()) {
			yoff = (float) (handler.getWorld().getMapHeight()*Tile.TILE_HEIGHT-handler.getHeight());
		}

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
	
	public void setCameraSpring(float cameraSpring) {
		this.cameraSpring = cameraSpring;
	}
	
}
