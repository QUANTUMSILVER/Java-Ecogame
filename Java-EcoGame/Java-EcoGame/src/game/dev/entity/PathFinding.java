package game.dev.entity;

import game.dev.Handler;
import game.dev.tile.Tile;
import game.dev.world.World;

public class PathFinding {
	private int destx, desty, cx, cy, counter;
	private int cn,ce,cs,cw;
	private Tile[][] worldTiles;
	private int[][] assignment;
	private Handler handler;
	
	public int[][] getPath(int x, int y, int destX, int destY) {
		int counter = 0;
		System.out.println(handler.getWorld().getMapWidth());
		return assignment;
//		assignment = new int[handler.getWorld().getMapWidth()][handler.getWorld().getMapHeight()];
//		for (int i=0;i<handler.getWorld().getMapWidth();i++) {
//			for (int i1=0;i1<handler.getWorld().getMapHeight();i1++) {
//				if (worldTiles[i][i1].isPath()) {
//					assignment[i][i1] = -1;
//				}else {
//					assignment[i][i1] = (Integer) null;
//				}
//			}
//		}
//		while (assignment[x][y] == -1) {
//			worldTiles = World.getTiles();
//			assignment[destX][destY] = 0;
//			for (int cx=0;cx<handler.getWorld().getMapWidth();cx++) {
//				for (int cy=0;cy<handler.getWorld().getMapHeight();cy++) {
//					counter++;
//					if (assignment[cx][cy] != (Integer) null && assignment[cx][cy] != -1 && assignment[cx][cy] > counter) {
//						cn = cy-1;
//						cs = cy+1;
//						ce = cx+1;
//						cw = cx-1;
//						if (cn >= 0) {
//							if (worldTiles[cx][cn].isPath()) {
//								assignment[cx][cn] = counter;
//							}
//						}
//						if (cs <= handler.getWorld().getMapHeight()) {
//							if (worldTiles[cx][cs].isPath()) {
//								assignment[cx][cs] = counter;
//							}
//						}
//						if (ce <= handler.getWorld().getMapWidth()) {
//							if (worldTiles[ce][cy].isPath()) {
//								assignment[ce][cy] = counter;
//							}
//						}
//						if (cw >= 0) {
//							if (worldTiles[cw][cy].isPath()) {
//								assignment[ce][cy] = counter;
//							}
//				 		}
//					}
//				}
//			}
//		}
//		System.out.println(assignment);
//		return assignment;
	}
}
