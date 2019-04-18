
package novaWarPackage;
/**
 * Super class for the ship class
 * that provides position.
 * 
 * @author Kevin Wu
 *  */
public abstract class Entity {	
	protected float xPos;
	protected float yPos;

	//creates a new entity as an x and y position
	public Entity(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	/**
	 * @return x position
	 *  */
	protected float getXPos() {
		return xPos;
	}
	/**
	 * @return y position
	 *  */

	protected float getYPos() {
		return yPos;
	}

	/**
	 * changes x position by supplied amount
	 * @param change in x position 
	 * */
	protected void setXPos(float change) {
		xPos =+ change;
	}
	/**
	 * changes y position by supplied amount
	 * @param change in y position 
	 * */
	protected void setYPos(float change) {
		xPos =+ change;
	}
}

