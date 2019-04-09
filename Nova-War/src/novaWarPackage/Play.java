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
	public int shipY = 200;
	public int shipX = 200;
	public int p2X = 100;
	public int p2Y = 100;
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
		p1 = new Ship(20, 50, player1, shot, 150, 150, 0 ,0, false);
		p2 = new Ship(20, 50, player2, shot, 150, 150, 0 ,0, false);
		pewpew = new Shot(new Vector2f(Mouse.getX()+5, Mouse.getY() - 400), new Vector2f(0, 100), 50);
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		p1.getImg().draw(shipX, shipY, .2f);
		p2.getImg().draw(p2X, p2Y, .2f);
		
		g.fillRect(0, 0, 100, 10);
		g.setColor(Color.green);

		g.fillRect(300, 390, 100, 10);
		g.setColor(Color.green);
	}

	@Override
	public void update(GameContainer controller, StateBasedGame arg1, int t) throws SlickException {
		
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
		
		
		
		if (Mouse.isButtonDown(1)) {

			pewpew.update(t);

		}

	}

	@Override
	public int getID() {
		return 1;
	}

}
