package game.dev.tile;

import game.dev.Handler;
import game.dev.gfx.Assets;

public class GrassTile extends Tile{
	
	public GrassTile(Handler handler, int x, int y){
		super(handler, Assets.grassTile, x, y);
	}
	@Override
	public boolean canBuild() {
		return true;
	}
	
}
