package novaWarPackage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;

public class Play extends BasicGameState {
	public static int shipY = 400;
	public static int shipX = 200;

	Ship tank;
	Image tankI;
	Image shot;
	Shot pewpew;
	boolean alive;
	int Score;
	public Play(int play) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		tankI = new Image("/IMG/ship.png");
		shot =  new Image("IMG/7062bbab49726403b4efb40d856412f0.gif");
		tank = new Ship(20, 5, "tank", 50, tankI, shot);
		tank.init();
		alive = true;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if(alive) {
		tank.project.render(gc, g);
		
		tank.getImg().draw(shipX, shipY, .2f);
		}else {
			g.drawString("Game Over!!!",50 , 50);
			
		}
	

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int t) throws SlickException {
		// TODO Auto-generated method stub
		shipY = 400 - Mouse.getY();
		shipX = Mouse.getX();
		
		tank.project.update(t);
		if(Mouse.isButtonDown(1)) {
			alive = false;
			
			
		}
		
		

		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
