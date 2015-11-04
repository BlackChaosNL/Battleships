/**
 * The AircraftCarrier boat to be added to Square.
 * 
 * @author Jeroen Vijgen
 *
 */
public class AircraftCarrier extends Ship {
	private String name = "A";
	private String fullName = "AircraftCarrier";
	private int length = 5;
	private int hits;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the hits
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * @param hits
	 *            the hits to set
	 */
	public void setHits(int hits) {
		this.hits = hits;
	}
}