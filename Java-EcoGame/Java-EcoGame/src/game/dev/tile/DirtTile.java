package game.dev.tile;

import game.dev.Handler;
import game.dev.gfx.Assets;

public class DirtTile extends Tile{
	
	public DirtTile(Handler handler, int x, int y){
		super(handler, Assets.dirtTile, x, y);
	}
	@Override
	public boolean canBuild() {
		return true;
	}
	
}
