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

public class Shot {
	private Vector2f pos;
	private Vector2f speed;
	private int MAX_LIFE = 1000;
	private int life = 0;
	private boolean alive = true;

	int damage;
	final static int width = 10;
	final static int height = 10;
	private final String ship;
	static Sound shoot;

	// called from ship
	public Shot(Vector2f pos, Vector2f speed, int damage, String ship) throws SlickException {
		this.pos = pos;
		this.speed = speed;
		this.damage = damage;
		this.ship = ship;
		shoot = new Sound("Sound/pew-pew-lame-sound-effect.wav");
	}

	public void update(int t) {
		if (ship.equals("p1")) {
			if ((pos.y < 399 && pos.y > 0) && Play.hit1 == false) {
				Vector2f actSpeed = speed.copy();
				actSpeed.scale(t / 300f);
				pos.y -= actSpeed.y;
				alive = true;
				++life;

			} else {
				shoot.play();
				pos.y = Play.p1.getYPos();
				pos.x = Play.p1.getXPos();
			}
		} else {
			if ((pos.y < 399 && pos.y > 0) && Play.hit2 == false) {
				Vector2f actSpeed = speed.copy();
				actSpeed.scale(t / 300f);
				pos.y += actSpeed.y;
				alive = true;
				++life;
			} else {
				shoot.play();
				pos.y = Play.p2.getYPos() + 20;
				pos.x = Play.p2.getXPos();
			}
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setColor(Color.pink);
		g.fillOval(pos.x, pos.y, 10, 10);
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
	
	public Vector2f getPos() {
		return pos;
	}
	// removes shot from screen

}
