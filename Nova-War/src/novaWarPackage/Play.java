
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

import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.Timer;

import org.lwjgl.input.Mouse;

public class Play extends BasicGameState {
	public static int p1X = 200;
	public static int p1Y = 200;
	public static int p2X = 100;
	public static int p2Y = 100;
	private int time = 0;
	public static int score = 0;
	public static Ship p1, p2;
	Image player1, player2;
	Image shot;
	Shot pewpew;
	public Rectangle p1health;
	public Rectangle p2health;

	public Play(int play) {

	}

	public static void main(String[] args) {

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		p1health = new Rectangle(0, 0, 100, 10);
		player1 = new Image("IMG/ship.png");
		player2 = new Image("IMG/ship.png", true, 10);
		shot = new Image("IMG/7062bbab49726403b4efb40d856412f0.gif");
		p1 = new Ship(20, 50, player1, shot, 40, 40, 0, 0, false);
		p2 = new Ship(20, 50, player2, shot, 360, 360, 0, 0, false);
		pewpew = new Shot(new Vector2f(Mouse.getX() + 5, Mouse.getY() - 400), new Vector2f(0, 100), 50);
    p1.init();
    p2.init();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		p1.render(gc, arg1, g, true);
		p2.render(gc, arg1, g, false);

		g.fillRect(0, 0, p1.getHp() * 10, 10);
		g.setColor(Color.green);

		g.fillRect(200, 390, p2.getHp() * 10, 10);
		g.setColor(Color.green);
	}

	@Override
	public void update(GameContainer controller, StateBasedGame arg1, int t) throws SlickException {
		p1.update(controller, arg1, t, true);
		p2.update(controller, arg1, t, false);


		if (Mouse.isButtonDown(1)) {
			pewpew.update(t);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
	
	public void checkHits(Shot s, Ship ship) {
		double shipX = 0;
		double shipY = 0;
		int shipW = 0;
		int shipL = 0;
		
		double diffx;
		double diffy;
		
		double shotX = 0;
		double shotY = 0;
		double shotW = 10;//these 2 numbers are defined when creating the shot
		double shotL = 10;
			shipX = ship.getXPos(); 
			shipY = ship.getYPos();
			shipW = ship.getImage().getWidth();
			shipL = ship.getImage().getHeight();
			shotX = s.getX();
			shotY = s.getY();
				
			diffx = .5*shotW + .5*shipW;
			diffy = .5*shotL + .5*shipL;
				if ((shotX - shipX >= -(diffx) && shotX - shipX <= diffx) && (shotY - shipY >= -(diffy) && shotY - shipY <= diffy) ){
					ship.minusHp(1);
				}
	}

}
