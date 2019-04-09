package novaWarPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;


public class Ship extends Entity  {


	
	private int hp;
	private int damage;
	protected Image img;
	protected Image shotI;
	protected Shot project;
	boolean isBadGuy;
	boolean alive;
	
	public Ship(int hp, int damage, Image img, Image shotI, double xPos, double yPos, double dY, double dX, boolean isBadGuy) {
		super(xPos, yPos, dY, dX);
		this.isBadGuy = isBadGuy;
		this.hp = hp;
		this.damage = damage;
		this.img = img;
		this.shotI = shotI;
		this.alive = true;
		
		
	}
	public Image getImg() {
		return this.img;
	}
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void minusHp(int minus) {
		this.hp -= minus;
	}
	

	


	//creates a shot
	public void init() throws SlickException  {
		project = new Shot(new Vector2f(Play.shipX, Play.shipY), new Vector2f(0, 100), 50);
	}
	
	
	
	
	
}
