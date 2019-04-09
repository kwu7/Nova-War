
package novaWarPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Ship extends Entity {

	private int hp;
	private int damage;
	protected Image img;
	protected Image shotI;
	protected Shot project;
	boolean isBadGuy;
	boolean alive;

	public Ship(int hp, int damage, Image img, Image shotI, double xPos, double yPos, double dY, double dX,
			boolean isBadGuy) {
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

	public void render(GameContainer gc, StateBasedGame arg1, Graphics g, boolean player1) throws SlickException {
		if (player1)
			getImg().draw(Play.p1X, Play.p1Y, .2f);
		else
			getImg().draw(Play.p2X, Play.p2Y, .2f);
	}

	public void update(GameContainer controller, StateBasedGame arg1, int t, boolean player1) throws SlickException {
		if(!player1) {
			if (controller.getInput().isKeyDown(Input.KEY_A)) {
				if (!(Play.p2X <= 0))
					Play.p2X -= 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_D)) {
				if (!((Play.p2X + 33) >= 400))
					Play.p2X += 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_W)) {
				if (!(Play.p2Y <= 0))
					Play.p2Y -= 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_S)) {
				if (!(Play.p2Y + 60 >= 400))
					Play.p2Y += 6;
			}
		}
		else
			if (controller.getInput().isKeyDown(Input.KEY_DOWN)) {
				if (!(Play.p1Y + 60 >= 400))
					Play.p1Y += 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_UP)) {
				if (!(Play.p1Y <= 0))
					Play.p1Y -= 3;
			}
			if (controller.getInput().isKeyDown(Input.KEY_LEFT)) {
				if (!(Play.p1X <= 0))
					Play.p1X -= 3;
			}
			if (controller.getInput().isKeyDown(Input.KEY_RIGHT)) {
				if (!(Play.p1X + 33 >= 400))
					Play.p1X += 3;
			}
				
				
	}

}

	//creates a shot
	public void init() throws SlickException  {
		project = new Shot(new Vector2f(Play.shipX, Play.shipY), new Vector2f(0, 100), 50);
	}
	
	

	