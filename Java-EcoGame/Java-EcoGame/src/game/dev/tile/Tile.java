package game.dev.tile;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile waterTile = new WaterTile(0);
	public static Tile grassTile = new GrassTile(1);
	
	///
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	
	protected Color color;
	protected int id;
	
	Tile(Color color, int id){
		this.id = id;
		this.color = color;//change to image
		
		tiles[id] = this;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		//change to image
		g.setColor(color);
		g.fillRect(x, y, TILE_WIDTH, TILE_HEIGHT);
	}
	
	public int getid() {
		return id;
	}
	
}
