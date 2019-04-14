package novaWarPackage;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Renders ships and corresponding shots.
 * Checks collision between ships and whether ships have been hit.
 * 
 *  @author Yveder Joseph
 *  @author Kevin Wu
 *  @author Alex Creem
 *  */
public class Play extends BasicGameState {
	public static Ship p1, p2;
	Image player1, player2;
	Image shot;
	public static boolean hit1;
	public static boolean hit2;
	static boolean gameOver;
	static int endTimer = 0;
	Sound boom;
	Sound hitSound;
	private SpriteSheet explosion;
	private Animation explosionAnim;
	
	public Play(int play) {

	}

	public static void main(String[] args) {

	}
	/**
	 * Initializes all variables
	 * @return void */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		player1 = new Image("IMG/ship.png");
		player2 = new Image("IMG/ship.png", true, 100);

		p1 = new Ship(400, 50, player1, shot, 320, 320, "p1");
		p2 = new Ship(400, 50, player2, shot, 40, 40, "p2");
		explosion = new SpriteSheet("IMG/explosion.png",100,100);
		explosionAnim = new Animation(explosion, 100);
		
		p1.init();
		p2.init();
		
		gameOver = false;
		
		boom = new Sound("Sound\\Flashbang-Kibblesbob-899170896.wav");
		hitSound = new Sound("Sound/roblox-death-sound_1.wav");
	}
	/**
	 * Renders ships, shots and explosion animation
	 *  */
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
	
		if(p1.getHp() < 1 && p2.getHp() < 1) {
			g.drawString(String.format("Two warriors leave this plane in disgrace%nto begin anew press space"), 10, 200);
			
			if((endTimer >= 100) && (endTimer <= 1200)) {
			explosionAnim.draw(p1.getXPos(), p1.getYPos());
			explosionAnim.draw(p2.getXPos(), p2.getYPos());
			}
		}
		else {
		if (p1.getHp() > 1) {
			p1.render(gc, arg1, g);
			g.fillRect(400, 390, -(p1.getHp()), 10);
			
			g.setColor(Color.green);
		} else {
			if((endTimer >= 100) && (endTimer <= 1200)) {
			explosionAnim.draw(p1.getXPos(), p1.getYPos());
			}
			g.drawString("Player 2 Wins! -- press space to continue", 10, 200);
		}
		if (p2.getHp() > 1) {
			p2.render(gc, arg1, g);
			g.fillRect(0, 0, p2.getHp(), 10);
			g.setColor(Color.green);
		} else {
			if((endTimer >= 100) && (endTimer <= 1200)) {
			explosionAnim.draw(p2.getXPos(), p2.getYPos());
			}
			g.drawString("Player 1 Wins! -- press space to continue", 10, 200);
			
		}
		}
		g.drawString(String.format("%d", endTimer),10, 300);
		
	}
/**
 * Updates parameters of ships based on user input
 * */
	@Override
	public void update(GameContainer controller, StateBasedGame sbg, int t) throws SlickException {
		p1.update(controller, sbg, t, true);
		p2.update(controller, sbg, t, false);
		hit1 = checkHits(p1.project, p2);
		hit2 = checkHits(p2.project, p1);
		CheckColision();
		gameOver = checkGameStatus();
		
		
		if (gameOver) {
			endTimer += t;
			if((endTimer >= 100) && (endTimer <= 150)) {
			boom.play();	
			}
			Shot.shoot.stop();
			
			if (controller.getInput().isKeyDown(Input.KEY_SPACE)) {
				p1.setHp(400);
				p2.setHp(400);

				p1.setXPos(320);
				p1.setYPos(360);
				p2.setXPos(40);
				p2.setYPos(40);
				
				endTimer = 0;
				
				Menu.click.play();
				sbg.enterState(0);
			}
		}
	}

	@Override
	public int getID() {
		return 1;
	}
/**
 * Checks whether ship has been hit by shot of other
 * @param ship, shot of other ship
 * @param if supplied ship has been hit
 *  */
	public boolean checkHits(Shot s, Ship ship) {
		double shipX = 0;
		double shipY = 0;
		int shipW = 0;
		int shipL = 0;

		double diffx;
		double diffy;

		double shotX = 0;
		double shotY = 0;
		double shotW = 10;// these 2 numbers are defined when creating the shot
		double shotL = 10;
		boolean hit = false;

		shipW = ship.getImg().getWidth();
		shipL = ship.getImg().getHeight();
		shipX = ship.getXPos() + (.15 * shipW) / 2;
		shipY = ship.getYPos() + (.15 * shipL) / 2;
		shotX = s.getX();
		shotY = s.getY();

		diffx = .1 * shotW + .1 * shipW;
		diffy = .1 * shotL + .1 * shipL;
		
		if(!gameOver)
		if ((shotX - shipX >= -(diffx) && shotX - shipX <= diffx)
				&& (shotY - shipY >= -(diffy) && shotY - shipY <= diffy)) {
			ship.minusHp(40);
			hitSound.play();
			hit = true;
		}

		return hit;
	}
	/**
	 * Checks if ships have collided
	 * if true moves them apart
	 * 
	 *  */
  	public void CheckColision(){
	double shipDiffX = p1.getXPos() - p2.getXPos();
	double shipDiffY = p1.getYPos() - p2.getYPos();
	
	
	if(((shipDiffX <= 30) && (shipDiffX >= 0)) && (shipDiffY <= 30 && shipDiffY >= 0 )) {
		p1.minusHp(100);
		p2.minusHp(100);
		p1.xPos += 30;
		p2.xPos -= 30;
		hitSound.play();
	}
	if((shipDiffX >= -30 ) && (shipDiffX <= 0) && (shipDiffY >= -30 && shipDiffY <= 0 )){
		p1.minusHp(100);
		p2.minusHp(100);
		p1.xPos -= 30;
		p2.xPos += 30;
		hitSound.play();
	}
	if(((shipDiffY <= 45) && (shipDiffY >= 0)) && ((shipDiffX >= -30 && shipDiffX <= 0 ) || (shipDiffX <= 30 && shipDiffX >= 0 ))) {
		p1.minusHp(100);
		p2.minusHp(100);
		p1.yPos += 30;
		p2.yPos -= 30;
		hitSound.play();
	}
	if((shipDiffY >= -50 ) && (shipDiffY <= 0) && ((shipDiffX >= -30 && shipDiffX <= 0 ) || (shipDiffX <= 30 && shipDiffX >= 0 ))){
		p1.minusHp(100);
		p2.minusHp(100);
		p1.yPos -= 30;
		p2.yPos += 30;
		hitSound.play();
		
	}
	
	}

  	/**
  	 * Checks whether either ship have been killed
  	 * 
  	 *  @return if either chip has been killed
  	 */
  	
	public boolean checkGameStatus() {
		if (p1.getHp() < 1 || p2.getHp() < 1) {
			return true;
		}
		return false;
	}
}


