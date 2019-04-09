
package novaWarPackage;

public abstract class Entity {	
	protected double xPos;
	protected double yPos;
	protected double dY;
	protected double dX;
	
	
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
	
	protected void setXPos(int change) {
		xPos =+ change;
	}
	protected void setYPos(int change) {
		xPos =+ change;
	}
}

