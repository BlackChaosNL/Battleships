import java.util.Scanner;

class InteractionHelper {
	private Scanner scanner = new Scanner(System.in);
	private String string;
	private int integer;
	private String key;

	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	/**
	 * @param string
	 *            the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}

	/**
	 * @return the integer
	 */
	public int getInteger() {
		return integer;
	}

	/**
	 * @param integer
	 *            the integer to set
	 */
	public void setInteger(int integer) {
		this.integer = integer;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Return a valid string.
	 * 
	 * @param question
	 */
	public void askString(String question) {
		System.out.print(question);
		String response = scanner.next();
		try {
			this.setString(response);
		} catch (Exception e) {
			System.err.println("Helaas klopt uw input niet, vul iets geldigs in.");
			this.askString(question);
		}
	}

	/**
	 * Return a valid int.
	 * 
	 * @param question
	 */
	public void askInt(String question) {
		System.out.print(question);
		int response = scanner.nextInt();
		try {
			this.setInteger(response);
		} catch (Exception e) {
			System.err.println(
					"Helaas klopt uw input niet, vul iets geldigs in.[0 tot n(Alle natuurlijke getallen in het universum)]");
		}
	}

	/**
	 * Checks an integer range, and returns integer.
	 * 
	 * @param question
	 * @param startRange
	 * @param endRange
	 */
	public void askIntRange(String question, int startRange, int endRange) {
		System.out.print(question);
		try {
			int response = scanner.nextInt();
			if (response >= startRange && response <= endRange) {
				this.setInteger(response);
			} else {
				System.out.println(
						"Helaas klopt uw input niet, het getal valt niet binnen:" + startRange + " en: " + endRange);
			}
		} catch (Exception e) {
			System.out.println("Helaas klopt uw input niet, vul iets geldigs in.");
			this.askIntRange(question, startRange, endRange);
		}
	}

	/**
	 * Constantly ask the user for (board) input.
	 * 
	 * @param string
	 */
	public void askUserInput(String string) {
		System.out.print(string);
		String response = scanner.next();
		try {
			char firstPiece = response.toUpperCase().charAt(0);
			int secondPiece = Integer.parseInt(response.substring(1));
			if (firstPiece >= 'A' && firstPiece <= 'J') {
				if (secondPiece >= 1 && secondPiece <= 10) {
					this.setKey("" + firstPiece + secondPiece);
				} else {
					System.err.println("Deze rij bestaat niet.");
				}
			} else {
				System.err.println("Deze kolom bestaat niet.");
			}
		} catch (Exception e) {
			System.err.println("U heeft iets ingevoerd wat niet klopt.");
		}
	}
}