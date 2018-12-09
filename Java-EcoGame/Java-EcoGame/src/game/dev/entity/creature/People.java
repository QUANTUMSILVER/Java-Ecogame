package game.dev.entity.creature;

import java.awt.Graphics;

import game.dev.Handler;
import game.dev.entity.PathFinding;
import game.dev.gfx.Assets;
import game.dev.tile.Tile;

public class People extends Creature{
	
	private float x, y;
	
	private int age, happiness, wealth, education, lifeSpan, wage;
	private boolean employed, dead, sick, male;
	private int resilience = (int)(Math.random() * 100 + 1);
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
//		if (age>lifeSpan) {
//			dead = true;
//		}
//		if (happiness<1/(resilience/100)) {
//			dead = true;
//		}
//		if (sick) {
//			lifeSpan -= 1/60;
//		}
//		if (employed) {
//			
//			wealth += wage/60;
//		}
		handler.getPathFinder().getPath(0,0,10,10);
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getWealth() {
		return wealth;
	}

	public void setWealth(int wealth) {
		this.wealth = wealth;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public int getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public boolean isEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean isSick() {
		return sick;
	}

	public void setSick(boolean sick) {
		this.sick = sick;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public int getResilience() {
		return resilience;
	}

	public void setResilience(int resilience) {
		this.resilience = resilience;
	}

	public People(Handler handler, float x, float y) {
		super(handler, x, y);
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.npcMale, (int) (x - handler.getCamera().getXoff()), (int) (y - handler.getCamera().getYoff()), Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT, null);
	}

}
