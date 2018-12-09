package game.dev.structure;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Structure {
	
	public static Structure[] structures = new Structure[256];
	
	
	protected int id;
	protected BufferedImage texture;
	
	public Structure(BufferedImage texture, int id) {
		this.id = id;
		this.texture = texture;
		structures[id] = this;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, null);
	}
	
	public void update() {
		
	}
	
}
