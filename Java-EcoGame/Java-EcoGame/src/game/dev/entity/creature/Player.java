package game.dev.entity.creature;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game.dev.Handler;
import game.dev.gfx.MyColor;

public class Player extends Creature{
	
	private float playerSpeed = 3;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x = x;
		this.y = y;
	}

	@SuppressWarnings("unused")
	private void move() {
		float velx = 0;
		float vely = 0;
		if(handler.getGame().getKeyManager().getKey(KeyEvent.VK_W)) {
			vely -= playerSpeed;
		}else if(handler.getGame().getKeyManager().getKey(KeyEvent.VK_S)) {
			vely += playerSpeed;
		}if(handler.getGame().getKeyManager().getKey(KeyEvent.VK_A)) {
			velx -= playerSpeed;
		}else if(handler.getGame().getKeyManager().getKey(KeyEvent.VK_D)) {
			velx += playerSpeed;
		}
		
		float mag = (float) Math.sqrt(velx*velx + vely*vely);
		
		if(mag != 0) {
			x += velx * playerSpeed/mag;
			y += vely * playerSpeed/mag;
		}
	}
	
	@Override
	public void update() {
		//move();
		//handler.getCamera().focusEntity(this);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(MyColor.BLACK);
		g.fillRect((int) (x - handler.getCamera().getXoff()),(int) (y - handler.getCamera().getYoff()), CREATURE_WIDTH, CREATURE_HEIGHT);
	}
	
}
