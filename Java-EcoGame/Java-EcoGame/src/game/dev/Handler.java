package game.dev;

import java.awt.Canvas;

import javax.swing.JFrame;

import game.dev.display.Camera;
import game.dev.entity.EntityManager;
import game.dev.entity.PathFinding;
import game.dev.input.KeyManager;
import game.dev.input.MouseManager;
import game.dev.world.World;

public class Handler {
	
	private Game game;
	private World world;
	private EntityManager entityManager = new EntityManager(this);
	private PathFinding pathFinder = new PathFinding();
	
	
	public PathFinding getPathFinder() {
		return pathFinder;
	}
	public void setPathFinder(PathFinding pathFinder) {
		this.pathFinder = pathFinder;
	}
	public Handler(Game game) {
		this.game = game;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Camera getCamera() {
		return game.getCamera();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public JFrame getJFrame() {
		return game.getDisplay().getJFrame();
	}
	
	public Canvas getCanvas() {
		return game.getDisplay().getCanvas();
	}
	
}
