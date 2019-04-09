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
	private final String ship;
	// called from ship
	public Shot(Vector2f pos, Vector2f speed, int damage, String ship) {
		this.pos = pos;
		this.speed = speed;
		this.damage = damage;
		this.ship = ship;

	}

	

	public void update(int t) {
		if(ship.equals("p1")){
		if (pos.y < 399 && pos.y > 0 ) {
			Vector2f actSpeed = speed.copy();
			actSpeed.scale(t / 300f);
			pos.y -= actSpeed.y;
			alive = true;
			++life;
			
		}
		else {
			
			alive = false;
	
			pos.y = Play.shipY;
			pos.x = Play.shipX;
			life = 0;
		}
		}else {
			if ( pos.y < 399 && pos.y > 0 ) {
				Vector2f actSpeed = speed.copy();
				actSpeed.scale(t / 300f);
				pos.y += actSpeed.y;
				alive = true;
				++life;
				
			}
			else {
				
				alive = false;
		
				pos.y = Play.p2Y + 40;
				pos.x = Play.p2X;
				life = 0;
			}
		}

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		if(alive) {
		g.setColor(Color.pink);
		g.fillOval(pos.x, pos.y, 10, 10);
		g.drawString(String.format("Shot Pos: %f", pos.y), 100, 200);
		g.drawString(String.format("Mouse Pos: %d,%b ", Mouse.getY(), alive), 100, 300);
		
		
		
		}else {
			g.drawString(String.format("Alive: %b",alive), 200, 300);
			g.destroy();
			
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
