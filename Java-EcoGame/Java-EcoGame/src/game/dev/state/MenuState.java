package game.dev.state;

import java.awt.Graphics;

import game.dev.Handler;
import game.dev.gfx.Assets;
import game.dev.ui.Button;
import game.dev.ui.ClickListener;
import game.dev.ui.UIManager;

public class MenuState extends State{
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addUIObject(new Button(100, 100, 200, 200, Assets.startButton, new ClickListener() {
			@Override
			public void onClick() {
				State.setcState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	@Override
	public void update() {
		uiManager.update();
	}
	
}
