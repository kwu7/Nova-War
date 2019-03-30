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
	int shipY = 50;
	int shipX = 50;

	Ship tank;
	Image tankI;
	Image shot;
	Shot pewpew;

	public Play(int play) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		tankI = new Image("/IMG/ship.png");
		shot = new Image("IMG/7062bbab49726403b4efb40d856412f0.gif");
		tank = new Ship(20, 5, "tank", 50, tankI, shot);
		pewpew = new Shot(new Vector2f(shipX, shipY), new Vector2f(0, 100), 50);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if (Mouse.isButtonDown(1)) {
			pewpew.render(gc, g);
		}
		else if(!pewpew.getAlive()) {
			g.clear();
		}

		tank.getImg().draw(shipX, shipY, .2f);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int t) throws SlickException {
		// TODO Auto-generated method stub
		shipY = 400 - Mouse.getY();
		shipX = Mouse.getX();
		if (Mouse.getEventButton() == 1) {
			pewpew.update(t);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
