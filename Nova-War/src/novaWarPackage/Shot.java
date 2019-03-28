package novaWarPackage;

public class Shot {
	int xpos;
	int ypos;
	int speed;
	int damage;
	final static int width = 25;
	final static int height = 75;
	
	//called from ship
	public Shot(int xpos, int ypos, int speed, int damage) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.speed = speed;
		this.damage = damage;
	}
	public void move() {
		while(true) {
			this.ypos ++;
			
			try
			{
				Thread.sleep(5);
			}
			catch (InterruptedException ex) {
				
			}
		}
	}
	
	public int getY() {
		return this.ypos;
	}
	public int getX() {
		return this.xpos;
	}
	//removes shot from screen
	public void terminate() {
		
	}
	
	

}
