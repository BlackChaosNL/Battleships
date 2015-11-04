import java.util.*;

/**
 * The Field to play the game with.
 * 
 * @author Jeroen Vijgen
 *
 */

public class Field {
	private HashMap<String, Square> field = new HashMap<>();
	private ArrayList<String> shotsFired = new ArrayList<>();
	private ArrayList<String> setShipCoordinates = new ArrayList<>();
	Random random = new Random();

	/**
	 * Print the playing field.
     * @param cheating if cheating is true, print cheating field.
	 */
	public void print(boolean cheating) {
		for (int i = 10; i != 0; i--) {
			if (i < 10) {
				System.out.print(" ");
			}
			System.out.print(i);
			for (int n = 10; n != 0; n--) {
                if(cheating){
                    // Print cheating field.
                    if(this.getHashMapItem("" + (char)(75-n) + i).getShip() == null){
                        System.out.print("~");
                    }else{
                        System.out.print(this.getHashMapItem("" + (char)(75-n) + i).getShip().getName());
                    }
                }else {
                    // Print normal field.
                    if (this.shotsFired.contains("" + (char) (75 - n) + i)) {
                        if (this.getHashMapItem("" + (char) (75 - n) + i).getShip() == null) {
                            System.out.print("~");
                        } else {
                            if(this.getHashMapItem("" + (char) (75 - n) + i).getShip().getHits() == this.getHashMapItem("" + (char) (75 - n) + i).getShip().getLength()){
                                System.out.print(this.getHashMapItem("" + (char) (75 - n) + i).getShip().getName());
                            }else{
                                System.out.print("*");
                            }
                        }
                    } else {
                        System.out.print(".");
                    }
                }
			}
			System.out.println("");
		}
		System.out.print("  ");
		for (int m = 0; m < 10; m++) {
			System.out.print("" + (char) (65 + m));
		}
		System.out.println("");
	}

	/**
	 * Create the playing field by adding in boats and whitespaces (ie Blank Squares) and add into HashMap.
	 */
	public void createPlayingField() {
        this.addShips();
        this.addWhiteSpaces();
	}

	/**
	 * Adds in the ships into the HashMap.
	 */
	private void addShips() {
		Ship[] ships = { new AircraftCarrier(), new BattleShip(), new Destroyer(), new Patrolboat(), new Submarine() };
		int shipsAdded = 0;
		while (shipsAdded != 5) {
			boolean unique = false;
			while (unique == false) {
                int orientation = random.nextInt((1-0)+1);
				int letter = random.nextInt((11 - ships[shipsAdded].getLength()) - 1) + 1;
				int number = random.nextInt((11 - ships[shipsAdded].getLength()) - 1) + 1;
				int length = ships[shipsAdded].getLength();
				if(orientation == 0){
                    int isClean = 0;
                    for(int i = 0; i<length; i++){
                        if (!setShipCoordinates.contains("" + (char) (65 + letter) + (number+i))) {
                            isClean++;
                        }
                    }
                    if(isClean == length){
                        int counter = 0;
                        while (counter != ships[shipsAdded].getLength()) {
                            // Vertical ( ig b3, b4, b5, b6 )
                            this.field.put("" + (char) (65 + letter) + (number + counter), new Square(ships[shipsAdded]));
                            setShipCoordinates.add("" + (char) (65 + letter) + (number + counter));
                            counter++;
                        }
                        unique = true;
                    }
                }else{
                    int isClean = 0;
                    for(int i = 0; i<length; i++){
                        if (!setShipCoordinates.contains("" + (char) (65 + letter + i) + number)) {
                            isClean++;
                        }
                    }
                    if(isClean == length){
                        int counter = 0;
                        while (counter != ships[shipsAdded].getLength()) {
                            // Horizontal ( ig a2, b2, c2, d2 )
                            this.field.put("" + (char) (65 + letter + counter) + (number), new Square(ships[shipsAdded]));
                            setShipCoordinates.add("" + (char) (65 + letter + counter) + (number));
                            counter++;
                        }
                        unique = true;
                    }
                }
			}
			shipsAdded++;
		}
	}

	/**
	 * Adds whitespaces in the form of empty Squares.
	 */
	private void addWhiteSpaces() {
		for (int i = 1; i < 11; i++) {
			for (int n = 1; n < 11; n++) {
				if (this.getHashMapItem("" + (char) (64 + i) + n) == null) {
					this.field.put("" + (char) (64 + i) + n, new Square());
				}
			}
		}
	}

	/**
	 * Get Single HashMap item
	 * 
	 * @param key
	 * @return Square
	 */
	public Square getHashMapItem(String key) {
		return this.getField().get(key);
	}

	/**
	 * Check whether a key has already been given in.
	 * 
	 * @param key
	 */
	public void fired(String key) {
		if (shotsFired.contains(key)) {
			System.out.println("U heeft hier al geschoten.");
		} else {
			if (this.field.containsKey(key.toUpperCase())) {
				shotsFired.add(key);
                if(this.getHashMapItem(key.toUpperCase()).getShip() != null){
                    System.out.println("U heeft een boot geraakt!");
                    this.getHashMapItem(key).getShip().setHits(this.getHashMapItem(key).getShip().getHits()+1);
                    if(this.getHashMapItem(key).getShip().getHits() == this.getHashMapItem(key).getShip().getLength()){
                        System.out.println(this.getHashMapItem(key).getShip().getFullName()+" is gezonken.");
                    }
                }else{
                    System.out.println("Helaas, u heeft niks geraakt.");
                }
			}
		}
	}

	/**
	 * Did all ships sunk?
	 */
	public boolean allShipsSunk() {
        int hitsLanded = 0;
        for(int i = 0; i != setShipCoordinates.size(); i++){
            for(int n = 0; n != shotsFired.size(); n++){
                if(setShipCoordinates.toArray()[i].equals(shotsFired.toArray()[n])){
                    hitsLanded++;
                }
            }
        }
        if(hitsLanded == 17){
            return true;
        }else{
            return false;
        }

	}

	/**
	 * @return the field
	 */
	public HashMap<String, Square> getField() {
		return field;
	}
}