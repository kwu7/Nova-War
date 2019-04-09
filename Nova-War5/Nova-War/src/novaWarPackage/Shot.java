package novaWarPackage;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Graphics;
import org.lwjgl.input.Mouse;

public class Shot {
	private Vector2f pos;
	private Vector2f speed;
	private int MAX_LIFE = 1000;
	private int life = 0;
	private boolean alive = true;

	int damage;
	final static int width = 10;
	final static int height = 10;

	// called from ship
	public Shot(Vector2f pos, Vector2f speed, int damage) {
		this.pos = pos;
		this.speed = speed;
		this.damage = damage;

	}

	public void update(int t) {
		if (pos.y > 20) {
			Vector2f actSpeed = speed.copy();
			actSpeed.scale(t / 250f);
			pos.y -= actSpeed.y;
			pos.x = Mouse.getX();
			alive = true;
			
		}
		else {
			
			alive = false;
			pos.y = Mouse.getY();
			pos.x = Mouse.getX();
		}

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		if(alive) {
			g.setColor(Color.pink);
		g.fillOval(pos.getX(), pos.getY(), 10, 10);
		}
		
	}
	public boolean getAlive() {
		return alive;
	}
	
	public double getX() {
		return this.pos.x;
	}
	
	public double getY() {
		return this.pos.y;
	}
	// removes shot from screen
	

}
