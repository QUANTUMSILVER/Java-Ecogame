package game.dev.tile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.dev.Handler;
import game.dev.structure.Structure;
import game.dev.world.World;

public class Tile {
	
//	public static Tile[] tiles = new Tile[256];
//	public static Tile waterTile = new WaterTile(0);
//	public static Tile grassTile = new GrassTile(1);
//	public static Tile rockTile = new RockTile(2);
//	public static Tile dirtTile = new DirtTile(3);
//	
//	
//	///
//	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
//	
//	protected Structure structure;
//	protected BufferedImage texture;
//	protected int id;
//	
//	Tile(BufferedImage texture, int id){
//		this.id = id;
//		this.texture = texture;//change to image
//		
//		tiles[id] = this;
//	}
//	
//	public void update(Handler handler) {
//		if(structure != null) {
//			structure.update();
//		}
//	}
//	
//	public void render(Graphics g, float x, float y) {
//		g.drawImage(texture, (int) x, (int) y, TILE_WIDTH, TILE_HEIGHT, null);
//		if(structure != null) {
//			structure.render(g, (int) x, (int) y);
//		}
//	}
//	
//	public int getid() {
//		return id;
//	}
	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	
	protected Structure structure;
	protected BufferedImage texture;
	protected int x, y;
	protected Tile[][] worldTiles;
	
	protected Handler handler;
	
	public Tile(Handler handler, BufferedImage texture, int x, int y) {
		this.handler = handler;
		this.texture = texture;
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, (int) (x - handler.getCamera().getXoff()), (int) (y - handler.getCamera().getYoff()), TILE_WIDTH, TILE_HEIGHT, null);
		if(structure != null) {
			structure.render(g, (int) (x - handler.getCamera().getXoff()), (int) (y - handler.getCamera().getYoff()));
		}
	}
	
	public void printTile() {
		Rectangle bounds = new Rectangle((int) (x - handler.getCamera().getXoff()), (int) (y - handler.getCamera().getYoff()), TILE_WIDTH, TILE_HEIGHT);
		if(bounds.contains(handler.getMouseManager().getMousex(), handler.getMouseManager().getMousey())) {
			if (handler.getMouseManager().isLeftPressed()) {
				if (this.canBuild()) {
					worldTiles = World.getTiles();
					Tile t = new Road(handler,x,y);
					worldTiles[Math.floorDiv(x,Tile.TILE_WIDTH)][Math.floorDiv(y, Tile.TILE_HEIGHT)] = t;
					World.setTiles(worldTiles);
				}
			}
		}
	}
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public void update(Handler handler) {
		if(structure != null) {
			structure.update();
		}
	}

	public boolean canBuild() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean isPath() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
