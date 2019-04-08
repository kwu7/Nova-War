package novaWarPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Ship extends Entity{
	
	private int hp;
	private int damage;
	private int speed;
	protected Image img;
	protected Image shotI;
	protected Shot project;
	
	public Ship(int hp, int speed, String name, int damage, Image img, Image shotI) {
		this.hp = hp;
		this.damage = damage;
		this.speed = speed;
		this.img= img;
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
