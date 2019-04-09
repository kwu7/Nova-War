
package novaWarPackage;

public abstract class Entity {	
	protected double xPos;
	protected double yPos;
	protected double dY;
	protected double dX;
	
	
	public Entity(double xPos, double yPos) {
		// TODO Auto-generated constructor stub
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public Entity() {
		// TODO Auto-generated constructor stub
	}

	protected void move() {
		xPos += dX;
		yPos += dY;
		
	}
	
	protected double getXPos() {
		return xPos;
	}

	protected double getYPos() {
		return yPos;
	}
	
	protected double getDX() {
		return dX;
	}
	
	protected double getDY() {
		return dY;
	}
}

