package game.dev.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import game.dev.Handler;

public class EntityManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler) {
		entities = new ArrayList<Entity>();
	}
	
	public void update() {
		for (int i=0;i<entities.size();i++){
			Entity e = entities.get(i);
			e.update();
		}
	}
	
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
}
