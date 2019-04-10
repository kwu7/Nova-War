
package novaWarPackage;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import org.newdawn.slick.geom.Shape;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
	public static Ship p1, p2;
	Image player1, player2;

	Image shot;
	public static boolean hit1;
	public static boolean hit2;



	public Play(int play) {

	}

	public static void main(String[] args) {

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		player1 = new Image("IMG/ship.png");
		player2 = new Image("IMG/ship.png", true, 10);

		shot = new Image("IMG/7062bbab49726403b4efb40d856412f0.gif");
		p1 = new Ship(50, 50, player1, shot, 320, 320, "p1");
		p2 = new Ship(50, 50, player2, shot, 40, 40, "p2");
		
		p1.init();
		p2.init();


	
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		if (p1.getHp() > 1) {
		p1.render(gc, arg1, g);
		g.fillRect(350, 390, p1.getHp(), 10);
		g.setColor(Color.green);
		}
		else {
			g.drawString("Player 2 Wins! -- press space to continue", 10, 200);
			
		}
		if (p2.getHp() > 1) {
		p2.render(gc, arg1, g);
		g.fillRect(0, 0, p2.getHp(), 10);
		g.setColor(Color.green);
		}
		else {
			g.drawString("Player 1 Wins! -- press space to continue", 10, 200);
			
		}
		
		
		
	}

	@Override
	public void update(GameContainer controller, StateBasedGame sbg, int t) throws SlickException {

		p1.update(controller, sbg, t, true);
		p2.update(controller, sbg, t, false);
		hit1 =  checkHits(p1.project, p2);
		hit2 =  checkHits(p2.project, p1);
		
		if (p1.getHp() < 1 || p2.getHp() <1) {
			if (controller.getInput().isKeyDown(Input.KEY_SPACE)) {
				p1.setHp(50);
				p2.setHp(50);
				
				p1.setXPos(320);
				p1.setYPos(60);
				p2.setXPos(40);
				p2.setYPos(40);
				sbg.enterState(0);
			}
		}
		
		
	}


	@Override
	public int getID() {
		return 1;
	}

	public boolean checkHits(Shot s, Ship ship) {
		double shipX = 0;
		double shipY = 0;
		int shipW = 0;
		int shipL = 0;

		double diffx;
		double diffy;

		double shotX = 0;
		double shotY = 0;
		double shotW = 10;// these 2 numbers are defined when creating the shot
		double shotL = 10;
		boolean hit = false;
		
		shipW = ship.getImg().getWidth();
		shipL = ship.getImg().getHeight();
		shipX = ship.getXPos() + (.1* shipW) / 2;
		shipY = ship.getYPos()+ (.1 * shipL) / 2;
		shotX = s.getX();
		shotY = s.getY();

		diffx = .1 * shotW + .1 * shipW;
		diffy = .1 * shotL + .1 * shipL;
		if ((shotX - shipX >= -(diffx) && shotX - shipX <= diffx)
				&& (shotY - shipY >= -(diffy) && shotY - shipY <= diffy)) {
			ship.minusHp(4);
			hit = true;
		}
		return hit;

	}

}
