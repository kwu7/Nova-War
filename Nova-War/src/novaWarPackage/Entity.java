
package novaWarPackage;

public abstract class Entity {	
	protected float xPos;
	protected float yPos;

	//creates a new entity as an x and y position
	public Entity(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	protected float getXPos() {
		return xPos;
	}

	protected float getYPos() {
		return yPos;
	}

	
	protected void setXPos(float change) {
		xPos =+ change;
	}
	protected void setYPos(float change) {
		xPos =+ change;
	}
}

