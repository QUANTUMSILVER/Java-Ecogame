package game.dev.state;

import java.awt.Graphics;

import game.dev.Handler;
import game.dev.entity.creature.Player;
import game.dev.tile.Tile;
import game.dev.world.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		player = new Player(handler, 100, 100);
		
		world = new World(handler);
		handler.setWorld(world);
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

	@Override
	public void update() {
		world.update();
		player.update();
	}
	
}
