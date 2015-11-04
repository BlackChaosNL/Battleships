/**
 * Holds the playerclass for the BattleShips game.
 * 
 * @author Jeroen Vijgen
 *
 */
public class Player {
	private String name;
	private int turn;

	/**
	 * Constructor for setting the playername.
	 * 
	 * @param name
	 */
	public Player(String name) {
		this.setName(name);
	}

	/**
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * @return turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Sets turn.
     * @param turn
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }
}