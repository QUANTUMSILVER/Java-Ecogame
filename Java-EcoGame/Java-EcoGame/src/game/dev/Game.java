package game.dev;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.dev.display.Camera;
import game.dev.display.Display;
import game.dev.gfx.Assets;
import game.dev.input.KeyManager;
import game.dev.input.MouseManager;
import game.dev.state.GameState;
import game.dev.state.MenuState;
import game.dev.state.State;
import game.dev.tile.Tile;
import game.dev.world.World;

public class Game implements Runnable{
	
	private Display display;
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private int width, height;
	private String title;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//handler
	private Handler handler;
	
	//camera
	private Camera camera;
	
	//states
	public State gameState;
	public State menuState;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getJFrame().addKeyListener(keyManager);
		display.getJFrame().addMouseListener(mouseManager);
		display.getJFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		camera = new Camera(handler, 0, 0);
		//init states
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		//State.setcState(gameState);
		State.setcState(menuState);
		
	}
	private void update() {
		//System.out.println(handler.getWorld().checkBlock());
		camera.moveCamera();
		
		if(State.getcState() != null) {
			State.getcState().update();
		}
		
	}
	
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		// Draw Crap
		
		if(State.getcState() != null) {
			State.getcState().render(g);
		}
		
		// End Crap
		bs.show();
		g.dispose();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Camera getCamera() {
		return camera;
	}
	
	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}
	
	//////////////////////////////////////////////////////

	//////////////////////////////////////////////////////

	public void run() {
		init();
		
		int fps = 60;
		double timeperTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timeperTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println(ticks);
				ticks = 0;
				timer = 0;
				
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

