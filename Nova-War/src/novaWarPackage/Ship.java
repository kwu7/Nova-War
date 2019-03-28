package novaWarPackage;

import org.lwjgl.input.Mouse;

public class Ship {
	
	private int hp;
	private int speed;
	private int damage;
	private String name;
	
	public Ship(int hp, int speed, String name, int damage) {
		this.hp = hp;
		this.speed = speed;
		this.name = name;
		this.damage = damage;
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
	public void shoot() {
		new Shot(Mouse.getX(), Mouse.getY(), this.speed, this.damage);
	}
	
	
}
