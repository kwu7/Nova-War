package novaWarPackage;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
/**
 * This is the hub of the game where all the separate classes are connected
 * 
 * @author Yveder Joseph
 * @author Kevin Wu
 * @author Alex Creem
 * 
 *   */
public class NovaWar extends StateBasedGame {
	public static final int menu = 0;
	public static final int play = 1;
	public static final int instructions = 2;

	//Adds all the different stages
	public NovaWar(String title) {
		super(title);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Instructions(instructions));
	}
	//creates the game/window 
	public static void main(String[] args) throws SlickException {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new NovaWar("Nova_War"));
			app.setShowFPS(false);
			app.setVSync(true);
			app.setDisplayMode(400, 400, false);
			app.setAlwaysRender(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();

		}

	}
	
	//initializes the menu
	@Override
	public void initStatesList(GameContainer gC) throws SlickException {
		this.getState(menu).init(gC, this);
		this.enterState(menu);
	}

}
