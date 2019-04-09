
package novaWarPackage;

import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import javafx.animation.Timeline;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.input.Mouse;

public class Play extends BasicGameState {
	public int shipY = 400;
	public int shipX = 200;
	private Timer timer;
	private TimerTask task;
	Random rndm = new Random();

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
		tankI = new Image("IMG/ship.png");
		shot = new Image("IMG/7062bbab49726403b4efb40d856412f0.gif");
		tank = new Ship(20, 50, tankI, shot, 150, 150, 0 ,0, false);
		pewpew = new Shot(new Vector2f(Mouse.getX()+5, Mouse.getY() - 400), new Vector2f(0, 100), 50);
		timer = new Timer();
		ArrayList<Ship> enemies = new ArrayList<>();
		task = new TimerTask() {

			@Override
			public void run() {
//				enemies.add(new Ship(100, "tom", 50, tankI, shot, 300, 0 , 0 , 0, true));
//				enemies.get(0).getImg().draw(shipX, shipY, .2f);
				System.out.println("test");
			}
		};
		//timer.scheduleAtFixedRate(task, 1000, 5000);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if (Mouse.isButtonDown(1)) {
			pewpew.render(gc, g);
		} else if (!pewpew.getAlive()) {
			g.clear();
		}
		ArrayList<Ship> enemies = new ArrayList<>();
		task = new TimerTask() {

			@Override
			public void run() {
//				enemies.add(new Ship(100, "tom", 50, tankI, shot, 300, 0 , 0 , 0, true));
//				enemies.get(0).getImg().draw(shipX, shipY, .2f);
				System.out.println("test");
			}
		};
		tank.getImg().draw(shipX, shipY, .2f);
		timer.scheduleAtFixedRate(task, 1000, 5000);
		
		

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
