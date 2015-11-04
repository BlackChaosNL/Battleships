public class SeaBattle {
	private InteractionHelper IH = new InteractionHelper();
    private Player player;
    private Player player2;
	private Field field;
	private Field fieldPlayer2;

	/**
	 * Set basic items to play the initialise the game with.
	 *
	 * @param nPlayers
	 * @return
	 */
	public void BattleShip(int nPlayers) {
		IH.askString("Wat is uw naam?: ");
		Player player = new Player(IH.getString());
        this.setPlayer(player);
		System.out.println("Welkom bij zeeslag " + player.getName());
		Field field = new Field();
		field.createPlayingField();
		this.setField(field);
		if (nPlayers == 2) {
			IH.askString("Wat is de naam van uw tegenspeler?: ");
			Player player2 = new Player(IH.getString());
            this.setPlayer2(player2);
            System.out.println("Welkom bij zeeslag " + player2.getName());
			Field field2 = new Field();
			field2.createPlayingField();
			this.setFieldPlayer2(field2);
		}
	}

	/**
	 * Play the game.
	 *
	 * @param none
	 *
	 */
	public void play(boolean CHEAT) {
		try {
            boolean won = false;
			IH.askIntRange("Wilt u met een of twee spelers spelen?[1,2]:", 1, 2);
			this.BattleShip(IH.getInteger());
            if(IH.getInteger() == 1){
                while (!won) {
                    if(CHEAT){
                        this.getField().print(CHEAT);
                    }
                    this.getField().print(false);
                    IH.askUserInput(this.getPlayer().getName()+", voer een veld in(Bijv. A1):");
                    this.getField().fired(IH.getKey());
                    if(this.getField().allShipsSunk()){
                        won = true;
                    }
                }
                System.out.println(this.getPlayer().getName()+", u heeft gewonnen!");
            }else{
                while (!won) {
                    int turn = 0;
                    if(turn == 0){
                        this.getField().print(false);
                        IH.askUserInput(this.getPlayer().getName()+", voer een veld in(Bijv. A1):");
                        this.getField().fired(IH.getKey());
                        if(this.getField().allShipsSunk()){
                            won = true;
                        }
                        turn++;
                    }else{
                        this.getFieldPlayer2().print(false);
                        IH.askUserInput(this.getPlayer2().getName()+", voer een veld in(Bijv. A1):");
                        this.getFieldPlayer2().fired(IH.getKey());
                        if(this.getFieldPlayer2().allShipsSunk()){
                            won = true;
                        }
                        turn--;
                    }
                }
                System.out.println(this.getPlayer().getName()+", u heeft gewonnen!");
            }
        } catch (Exception e) {

		}

	}

    /**
     * Get player one.
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Set player one.
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets player two.
     * @return Player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Sets player two.
     * @param player2
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Gets player two's field.
     * @return Field
     */
    public Field getFieldPlayer2() {
        return fieldPlayer2;
    }

    /**
     * Set player two's field.
     * @param fieldPlayer2
     */
    public void setFieldPlayer2(Field fieldPlayer2) {
        this.fieldPlayer2 = fieldPlayer2;
    }
    /**
     * @return the field
     */
    public Field getField() {
        return field;
    }

    /**
     * @param field
     *            the field to set
     */
    public void setField(Field field) {
        this.field = field;
    }

}