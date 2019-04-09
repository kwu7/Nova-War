


package novaWarPackage;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
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

	public static int shipY = 200;
	public static int shipX = 200;
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
	boolean alive;

	public Play(int play) {
		
	}

	public static void main(String[] args) {



	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {


		 alive = true;

		p1health = new Rectangle(0, 0, 100, 10);
		player1 = new Image("IMG/ship.png");
		player2 = new Image("IMG/ship.png", true, 10);
		p1 = new Ship(20,50, player1,"p1");
		p2 = new Ship(20, 50, player2, "p2");
		
    p1.init();
    p2.init();
		

		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		p1.getImg().draw(shipX, shipY, .2f);
		p2.getImg().draw(p2X, p2Y, .2f);
		p1.project.render(gc, g);
		p2.project.render(gc, g);
		g.fillRect(0, 0, 100, 10);
		g.setColor(Color.green);

		g.fillRect(300, 390, 100, 10);
		g.setColor(Color.green);
	}

	@Override
	public void update(GameContainer controller, StateBasedGame arg1, int t) throws SlickException {
		p1.update(t);
		p2.update(t);
		p1.project.update(t);
		p2.project.update(t);
		if(controller.getInput().isKeyDown(Input.KEY_A)) {
			p2X -= 1;
 		}
		if(controller.getInput().isKeyDown(Input.KEY_D)) {
			p2X += 1;
 		}
		if(controller.getInput().isKeyDown(Input.KEY_W)) {
			p2Y -= 1;
 		}
		if(controller.getInput().isKeyDown(Input.KEY_S)) {
			p2Y += 1;
 		}
		
		
		if(controller.getInput().isKeyDown(Input.KEY_DOWN)) {
			shipY += 3;
 		}
		if(controller.getInput().isKeyDown(Input.KEY_UP)) {
			shipY -= 3;
 		}
		if(controller.getInput().isKeyDown(Input.KEY_LEFT)) {
			shipX -= 1;
 		}
		if(controller.getInput().isKeyDown(Input.KEY_RIGHT)) {
			shipX += 1;
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
			if(ship.name.equals("p1")) {
			shipX = ship.getXPos(); 
			shipY = ship.getYPos();
			}
			shipW = ship.getImg().getWidth();
			shipL = ship.getImg().getHeight();
			shotX = s.getX();
			shotY = s.getY();
				
			diffx = .5*shotW + .5*shipW;
			diffy = .5*shotL + .5*shipL;
				if ((shotX - shipX >= -(diffx) && shotX - shipX <= diffx) && (shotY - shipY >= -(diffy) && shotY - shipY <= diffy) ){
					ship.minusHp(1);
				}
	}


}
