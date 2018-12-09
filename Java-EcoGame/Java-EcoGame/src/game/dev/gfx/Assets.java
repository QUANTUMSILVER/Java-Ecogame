package game.dev.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	
	public static BufferedImage waterTile, grassTile, dirtTile, rockTile, road, school, work, cemetary, npcMale, npcFemale, npcDead;
	public static BufferedImage[] startButton;
	
	public static void init() {
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/texture/tileSheet.png"));
		startButton = new BufferedImage[2];
		
		waterTile = tileSheet.crop(0, 0, TILE_WIDTH, TILE_HEIGHT);
		grassTile = tileSheet.crop(TILE_WIDTH, 0, TILE_WIDTH, TILE_HEIGHT);
		dirtTile = tileSheet.crop(TILE_WIDTH, TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		rockTile = tileSheet.crop(0, TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		npcMale = tileSheet.crop(TILE_WIDTH*3, 0, TILE_WIDTH, TILE_HEIGHT*2);
		npcFemale = tileSheet.crop(TILE_WIDTH*4, 0, TILE_WIDTH, TILE_HEIGHT*2);
		npcDead = tileSheet.crop(TILE_WIDTH*5, 0, TILE_WIDTH, TILE_HEIGHT*2);
		road = tileSheet.crop(TILE_WIDTH*2, 0, TILE_WIDTH, TILE_HEIGHT);
		school = tileSheet.crop(TILE_WIDTH*2, TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		work = tileSheet.crop(TILE_WIDTH, TILE_HEIGHT*2, TILE_WIDTH, TILE_HEIGHT);
		cemetary = tileSheet.crop(0, TILE_HEIGHT*2, TILE_WIDTH, TILE_HEIGHT);
		
		startButton[0] = waterTile;
		startButton[1] = grassTile;
	}
	
	
}
