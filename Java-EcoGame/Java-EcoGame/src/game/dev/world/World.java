package game.dev.world;

import java.awt.Graphics;

import game.dev.Handler;
import game.dev.entity.EntityManager;
import game.dev.entity.creature.People;
import game.dev.tile.DirtTile;
import game.dev.tile.GrassTile;
import game.dev.tile.Road;
import game.dev.tile.RockTile;
import game.dev.tile.Tile;
import game.dev.tile.WaterTile;
import game.dev.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private static Tile[][] tiles;

	public World(Handler handler, String path){
		this.handler = handler;
		loadWorld(path);
		handler.getEntityManager().addEntity(new People(handler, 64, 64));
		handler.setWorld(this);
	}
	
	public void update() {
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height;y++) {
				handler.getEntityManager().update();
				getTile(x,y).update(handler);
			}
		}
	}
	
	public void render(Graphics g) {
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height;y++) {
				handler.getEntityManager().render(g);
				getTile(x,y).render(g);
				getTile(x,y).printTile();
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = tiles[x][y];
		if(t == null) {
			Tile t1 = new WaterTile(handler,x,y);
			return t1;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileasString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		tiles = new Tile[width][height];
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height;y++) {
				int index = (x+y*width)+2;
				if(Utils.parseInt(tokens[index]) == 0) {
					Tile t = new WaterTile(handler, x*Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT);
					tiles[x][y] = t;
				}else if(Utils.parseInt(tokens[index]) == 1) {
					Tile t = new GrassTile(handler, x*Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT);
					tiles[x][y] = t;
				}else if(Utils.parseInt(tokens[index]) == 2) {
					Tile t = new RockTile(handler, x*Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT);
					tiles[x][y] = t;
				}else if(Utils.parseInt(tokens[index]) == 3) {
					Tile t = new DirtTile(handler, x*Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT);
					tiles[x][y] = t;
				}else if(Utils.parseInt(tokens[index]) == 4) {
					Tile t = new Road(handler, x*Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT);
					tiles[x][y] = t;
				}
			}
		}		
	}
	
//	private float checkXClickedLocation() {
//		float mousex;
//		if (handler.getMouseManager().isLeftPressed()) {
//			mousex = handler.getMouseManager().getMousex();
//			mousex += handler.getCamera().getXoff();
//			return mousex;
//		}else {
//			return 0;
//		}
//	}
//	private float checkYClickedLocation() {
//		float mousey;
//		if (handler.getMouseManager().isLeftPressed()) {
//			mousey = handler.getMouseManager().getMousey();
//			mousey += handler.getCamera().getYoff();
//			return mousey;
//		}else {
//			return 0;
//		}
//	}
//	
//	public Tile checkBlock() {
//		int checkx = Math.floorDiv((int) checkXClickedLocation(),Tile.TILE_WIDTH);
//		int checky = Math.floorDiv((int) checkYClickedLocation(),Tile.TILE_HEIGHT);
//		if (!handler.getMouseManager().isLeftPressed()) {
//			return null ;
//		} else {
//			return getTile(checkx,checky);
//		}
//	}
	
	public static Tile[][] getTiles() {
		return tiles;
	}

	public static void setTiles(Tile[][] tiles) {
		World.tiles = tiles;
	}

	public int getMapWidth() {
		return width;
	}
	public int getMapHeight() {
		return height;
	}
}
