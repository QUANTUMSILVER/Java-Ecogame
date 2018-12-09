package game.dev.tile;

import game.dev.Handler;
import game.dev.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(Handler handler, int x, int y){
		super(handler, Assets.rockTile, x, y);
	}
	@Override
	public boolean canBuild() {
		return false;
	}
	
}
