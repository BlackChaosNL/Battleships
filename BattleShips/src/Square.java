/**
 * The Square to be included into the field class.
 * 
 * @author Jeroen Vijgen
 *
 */
public class Square {
	private Ship ship;

	public Square() {
	}

	/**
	 * 
	 * @param ship
	 */
	public Square(Ship ship) {
		this.setShip(ship);
	}

	/**
	 * @return the ship
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * @param ship
	 *            the ship to set
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}
}