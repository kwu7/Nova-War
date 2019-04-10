package novaWarPackage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Instructions extends BasicGameState{
	
	public Instructions(int i) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		String obj = "OBJECTIVE";
		String obj2 = "A 1v1 battle royale in which you have to kill your opponent";
		String inst = "INSTRUCTIONS";
		String s1 = "Player1 uses ASWD to move.";
		String s2 = "Player2 uses ArrowKeys to move.";
		g.drawString(obj, 50, 85);
		g.drawString(obj2, 50, 90);
		g.drawString(inst, 50, 95);
		g.drawString(s1, 50, 100);
		g.drawString(s2, 50, 105);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
