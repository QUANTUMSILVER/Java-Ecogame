package game.dev.tile;

import game.dev.Handler;
import game.dev.gfx.Assets;

public class WaterTile extends Tile{
	
	public WaterTile(Handler handler, int x, int y){
		super(handler, Assets.waterTile, x, y);
	}
	@Override
	public boolean canBuild() {
		return false;
	}
}
