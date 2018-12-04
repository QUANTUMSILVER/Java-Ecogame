package game.dev.entity.creature;

import java.awt.Graphics;

import game.dev.Handler;
import game.dev.gfx.MyColor;

public class Player extends Creature{
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		handler.getCamera().focusEntity(this);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(MyColor.LIGHT_GREEN);
		g.fillRect((int) (x - handler.getCamera().getXoff()),(int) (y - handler.getCamera().getYoff()), CREATURE_WIDTH, CREATURE_HEIGHT);
	}
	
}
