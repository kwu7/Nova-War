
package novaWarPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 * creates main menu for game
 * @author Yveder Joseph
 * @author Kevin Wu
 * @author Alex Creem
 *  */
public class Menu extends BasicGameState {
	Image play;
	Image exit;
	Font f;
	Music back;
	static Sound click;
	private int state;
	
	public Menu(int state) {
		this.state = state;
		
	}
	public static void main(String[] args) {
		
	}
	//Initializes all sound and image on the game menu
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		play = new Image("IMG/Text-Button-Example.png");
		back = new Music("Sound/Scanglobe_-_02_-_SODAR.ogg");
		click = new Sound("Sound/Click2-Sebastian-759472264.wav");
		back.loop(1f, .8f);
	}
	//Renders text and images for game menu
	@Override
	public void render(GameContainer arg0, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("NOVA_WAR", 150, 50);
		g.drawString("Wu Conflict",140, 80);
		g.drawString("Press 'I' for instructions", 0, 385);
		play.draw(120, 150, .2f);
	}
	/*Creates hit box for new game button and checks for if I is presses as to enter
	  information menu
	*/
	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int arg2) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		if((posX > 120 && posX < play.getWidth() + 120) && posY > 89 && posY <  play.getWidth() + 209) {
			if(Mouse.isButtonDown(0)) {
				click.play();
				sbg.enterState(1);
			}
		}
		if(arg0.getInput().isKeyPressed(Input.KEY_I)) {
			click.play();
			sbg.enterState(2);
		}
		
	}
	//returns id for menu stage
	@Override
	public int getID() {
		return this.state;
	}

}

