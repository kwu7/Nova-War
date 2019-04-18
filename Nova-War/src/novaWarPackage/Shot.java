
package novaWarPackage;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Graphics;
import org.lwjgl.input.Mouse;
/**
 * This class generates the shots for the two ships
 * 
 *  @author Yveder Joseph
 *  @author Kevin Wu
 *  @author Alex Creem
 *  
 *  */
public class Shot {
	private Vector2f pos;
	private Vector2f speed;
	int damage;
	final static int width = 10;
	final static int height = 10;
	private final String ship;
	static Sound shoot;

	// called from ship
	//Constructor to create a shot object
	public Shot(Vector2f pos, Vector2f speed, int damage, String ship) throws SlickException {
		this.pos = pos;
		this.speed = speed;
		this.damage = damage;
		this.ship = ship;
		shoot = new Sound("Sound/pew-pew-lame-sound-effect.wav");
	}
	//Updates the position of the shot across the screen
	public void update(int t) {
		if (ship.equals("p1")) {
			if ((pos.y < 399 && pos.y > 0) && Play.hit1 == false) {
				Vector2f actSpeed = speed.copy();
				actSpeed.scale(t / 120f);
				pos.y -= actSpeed.y;
				

			} else {
				shoot.play();
				pos.y = Play.p1.getYPos();
				pos.x = Play.p1.getXPos();
			}
		} else {
			if ((pos.y < 399 && pos.y > 0) && Play.hit2 == false) {
				Vector2f actSpeed = speed.copy();
				actSpeed.scale(t / 120f);
				pos.y += actSpeed.y;
				
			} else {
				shoot.play();
				pos.y = Play.p2.getYPos() + 50;
				pos.x = Play.p2.getXPos();
			}
		}
	}
	//Renders in ship object on the screen
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setColor(Color.cyan);
		g.fillOval(pos.x, pos.y, 10, 10);
		
	}

	
	/**
	 * @return x position of shot 
	 * 
	 * */
	public double getX() {
		return this.pos.x;
	}
	/**
	 * @return y position of shot
	 *  
	 *  */
	public double getY() {
		return this.pos.y;
	}
	
	
	

}
