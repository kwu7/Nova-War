package novaWarPackage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;

public class Play extends BasicGameState {
	public int shipY = 400;
	public int shipX = 200;

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
		pewpew = new Shot(new Vector2f(Mouse.getX()+5, Mouse.getY() - 400), new Vector2f(0, 100), 50);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if (Mouse.isButtonDown(1)) {
			pewpew.render(gc, g);
		} else if (!pewpew.getAlive()) {
			g.clear();
		}

		tank.getImg().draw(shipX, shipY, .2f);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int t) throws SlickException {
		// TODO Auto-generated method stub
		shipY = 400 - Mouse.getY();
		shipX = Mouse.getX();
		if (Mouse.isButtonDown(1)) {
			System.out.print(Mouse.getY());
			pewpew.update(t);

		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public void checkHits(ArrayList<Shot> shots, ArrayList<Ship> ships) {
		double shipX = 0;
		double shipY = 0;
		int shipW = 0;
		int shipL = 0;
		
		double shotX = 0;
		double shotY = 0;
		double shotW = 5;
		double shotL = 5;
		for (int i = 0; i < ships.size(); i++) {
			shipX = ships.get(i).getImage().getX(); //doesnt work obviously. need getx/y methods for ship
			shipY = ships.get(i).getImage().getY();//see above
			shipW = 10;//arbitrary values, dont know how to get length/width for ships
			shipL = 10;
			for (int j = 0; j < shots.size(); j++) {
				shotX = shots.get(i).getX();//need to implement these still
				shotY = shots.get(i).getY();
				
				//15 is arbitrary value, should equal .5 * ship Width + .5 * shot Width (I think)
				if ((shotX - shipX >= -15 && shotX - shipX <= 15) && (shotY - shipY >= -15 && shotY - shipY <= 15) ){
					ships.get(i).minusHp(1);
				}
			}
		}
	}

}
