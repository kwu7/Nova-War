package novaWarPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	Image play;
	Image exit;
	Image leaderboard;
	
	public Menu(int state) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		play = new Image("IMG/Text-Button-Example.png");
		exit = new Image("IMG/jay-laws-start-game-button-png-no-glitch.jpg");
		leaderboard = new Image("IMG/Leaderboard-button.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawString("NOVA_WAR", 150, 50);
		g.drawString("Wu Conflict",140, 80);
		play.draw(120, 150, .2f);
		leaderboard.draw(120 + 20, 150, .2f);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		if((posX > 120 && posX < play.getWidth() + 120) && posY > 89 && posY <  play.getWidth() + 209) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		
		if(arg0.getInput().isKeyPressed(Input.KEY_D)) {
			sbg.enterState(2);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
