
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
/**
 * Creates  ship objects manipulated by players
 * 
 *  @author Yveder Joseph
 *  @author Kevin Wu
 *  @author Alex Creem
 *  
 *  */
public class Ship extends Entity {

	private int hp;
	private int damage;
	protected Image img;
	public Shot project;
	protected String name;
	
	//Constructor to create ship object
	public Ship(int hp, int damage, Image img, Image shotI, float xPos, float yPos, String name) {


		super(xPos, yPos);
		this.hp = hp;
		this.img = img;

		this.name = name;

		
	}
	/**
	 * @return image for ship object */
	public Image getImg() {
		return this.img;
	}
	/**
	 * @return health of ship object */
	public int getHp() {
		return this.hp;
	}
	/** 
	 * sets health of ship
	 * @param health of ship
	 * */
	public void setHp(int hp) {
		this.hp = hp;
	}
	/** 
	 * Subtracts health from ship
	 * @param amount to subtract health by
	 * */
	public void minusHp(int minus) {
		this.hp -= minus;
	}
	
  //this makes a shot
  public void init() throws SlickException  {
		project = new Shot(new Vector2f(this.getXPos(), this.getYPos()), new Vector2f(0,60), 50, this.name);
}
  	//This renders in the image for the ship and its corresponding shot 
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		
		getImg().draw(getXPos(), getYPos(), .2f);
		if(!Play.gameOver) {
		project.render(gc, g);
		}
	}
	/*This calls on the ships corresponding shot update method and updates the position of the ship based
	 * on Arrow Keys or WASD. The key binding is dependent on whether this is player 1 or 2. */
	public void update(GameContainer controller, StateBasedGame arg1, int t, boolean player1) throws SlickException {
		if(!Play.gameOver) {
		project.update(t);
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
	}

}

