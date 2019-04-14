
package novaWarPackage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Instructions extends BasicGameState {
	private String obj = "OBJECTIVE";
	private String obj2 = "A 1v1 battle royale in";
	private String obj3 = "which you have to";
	private String obj4 = "kill your opponent!!";
	private String inst = "INSTRUCTIONS";
	private String s1 = "Player1 uses Arrow Keys to move";
	private String s2 = "Player2 uses AWSD to move";
	private String credit = "Made by Yveder, Alex, and Kevin";

	public Instructions(int i) {

	}

	public static void main(String[] args) {

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {

		g.drawString(obj, 50, 45);
		g.drawString(obj2, 50, 70);
		g.drawString(obj3, 50, 85);
		g.drawString(obj4, 50, 100);
		g.drawString(inst, 50, 150);
		g.drawString(s1, 50, 175);
		g.drawString(s2, 50, 190);
		g.drawString(credit, 50, 220);
	
		g.drawString("Press 'I' to return back to home screen", 0, 385);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_I)) {
			arg1.enterState(0);
			Menu.click.play();
		}

	}

	@Override
	public int getID() {
		return 2;
	}

}


