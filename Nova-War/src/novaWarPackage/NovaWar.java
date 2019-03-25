package novaWarPackage;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class NovaWar extends StateBasedGame {
public static final int menu = 0;
public static final int play = 0;
	public NovaWar(String title) {
		super(title);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		AppGameContainer app;
		try {
			app  = new AppGameContainer(new NovaWar("Nova_War"));
			app.setDisplayMode(400, 400, false);
			app.setAlwaysRender(true);
			app.start();
		}catch(SlickException e) {
			e.printStackTrace();
			
		}
		
	}


	@Override
	public void initStatesList(GameContainer gC) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(menu).init(gC, this);
		this.enterState(menu);
	}

}
