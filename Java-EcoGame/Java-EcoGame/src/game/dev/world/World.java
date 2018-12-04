package game.dev.world;

import java.awt.Graphics;

import game.dev.Handler;
import game.dev.tile.Tile;

public class World {
	
	private Handler handler;
	
	private int width, height;
	private int[][] tiles;
	
	public World(Handler handler){
		loadWorld();
		this.handler = handler;
	}
	
	public void update() {
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height;y++) {
				getTile(x,y).update();
			}
		}
	}
	
	public void render(Graphics g) {
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height;y++) {
				getTile(x,y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getCamera().getXoff()), (int)(y*Tile.TILE_HEIGHT - handler.getCamera().getYoff()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) return Tile.waterTile;
		return t;
	}
	
	private void loadWorld() {
		width = 10;
		height = 10;
		tiles = new int[width][height];
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height;y++) {
				tiles[x][y] = (x+y) % 2;
			}
		}
		
	}
	
}
