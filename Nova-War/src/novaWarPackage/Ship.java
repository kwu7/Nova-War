package novaWarPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Ship extends Entity{
	
	private int hp;
	private int damage;


	protected Image img;
	protected Image shotI;
	protected Shot project;
	boolean isBadGuy;
	
	public Ship(int hp, int damage, Image img, Image shotI, double xPos, double yPos, double dY, double dX, boolean isBadGuy) {
		super(xPos, yPos, dY, dX);
		this.isBadGuy = isBadGuy;
		this.hp = hp;
		this.damage = damage;
		this.img = img;

		this.shotI = shotI;
		
		
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
	public Image getImage() {
		return this.img;
	}
	protected double getXPos() {
		return xPos;
	}

	protected double getYPos() {
		return yPos;
	}
	//creates a shot
	
	
	
}
