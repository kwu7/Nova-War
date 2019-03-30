package novaWarPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Ship {
	
	private int hp;
	private int speed;
	private int damage;
	private String name;
	protected Image img;
	protected Image shotI;
	protected Shot project;
	
	public Ship(int hp, int speed, String name, int damage, Image img, Image shotI) {
		this.hp = hp;
		this.speed = speed;
		this.name = name;
		this.damage = damage;
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
	//creates a shot
	
	
	
}
