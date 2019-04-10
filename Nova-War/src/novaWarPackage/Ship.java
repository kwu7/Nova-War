
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

	public Ship(int hp, int damage, Image img, Image shotI, float xPos, float yPos) {
		super(xPos, yPos);
		this.hp = hp;
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

	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		getImg().draw(getXPos(), getYPos(), .2f);
	}

	public void update(GameContainer controller, StateBasedGame arg1, int t, boolean player1) throws SlickException {
		if (!player1) {
			if (controller.getInput().isKeyDown(Input.KEY_A)) {
				if (!(getXPos() <= 0))
					xPos -= 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_D)) {
				if (!((getXPos() + 33) >= 400))
					xPos += 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_W)) {
				if (!(getYPos() <= 0))
					yPos -= 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_S)) {
				if (!(getYPos() + 60 >= 400))
					yPos += 6;
			}
		} else {
			if (controller.getInput().isKeyDown(Input.KEY_DOWN)) {
				if (!(getYPos() + 60 >= 400))
					yPos += 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_UP)) {
				if (!(getYPos() <= 0))
					yPos -= 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_LEFT)) {
				if (!(getXPos() <= 0))
					xPos -= 6;
			}
			if (controller.getInput().isKeyDown(Input.KEY_RIGHT)) {
				if (!(getXPos() + 33 >= 400))
					xPos += 6;
			}
		}
	}

	// creates a shot
	public void init() throws SlickException {
//		if (player1)
//			project = new Shot(new Vector2f(Play.p1X, Play.p1Y), new Vector2f(0, 100), 50);
//		else
//			project = new Shot(new Vector2f(Play.p2X, Play.p2Y), new Vector2f(0, 100), 50);
	}
}
