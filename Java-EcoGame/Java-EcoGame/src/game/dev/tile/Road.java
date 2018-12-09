package game.dev.tile;

import game.dev.Handler;
import game.dev.gfx.Assets;

public class Road extends Tile{
	public Road(Handler handler, int x, int y){
		super(handler, Assets.road, x, y);
	}
	@Override
	public boolean canBuild() {
		return true;
	}
	@Override
	public boolean isPath() {
		return true;
	}
}
