package model;

import java.util.ArrayList;

/**
 * The bag containing all the current available letters.
 * @author Simen
 *
 */
public class ScrabbleBag {
	CharList list;
	ArrayList<Letter> bag = new ArrayList<Letter>();
	
	private static ScrabbleBag instance = null;
	
	private ScrabbleBag() {
		list = CharList.instance();
		fillBag();
	}
	
	public ScrabbleBag instance() {
		if (instance == null) instance = new ScrabbleBag();
		return instance;
	}
	
	/**
	 * Called only once by constructor
	 */
	private void fillBag() {
		for (int i = 0; i < Constants.NUMBER_OF_DISTINCT_LETTERS; i++) {
			for (int k = 0; k < list.get(i).getTotalPieces(); k++) {
				bag.add(list.get(i));
			}
		}
	}
	
	
	/**
	 * Removes a random letter from bag 
	 * @return Random letter
	 */
	public Letter getRandomLetter() {
		if (bag.size() <= 0) {
			System.err.println("Somone fucked up! Bag is empty");
			return null;
		}
		int rand = (int) (Math.random() * bag.size());
		Letter temp = bag.get(rand);
		bag.remove(rand);
		return temp;
	}
	
	/**
	 * Returns the letter to the bag
	 * @param l
	 */
	public void returnLetter(Letter l) {
		if (bag.size() > Constants.BAG_SIZE) {
			System.err.println("Someone fucked up, bag is full!");
			return;
		}
		bag.add(l);
	}
	
	/**
	 * Test if the bag is missing the right amount of letters, when the board is filled with letters; 
	 * @return
	 */
	public boolean testBagAtFilledBoard() {
		return (bag.size() == Constants.BAG_SIZE - (Constants.MATRIX_HEIGHT * Constants.MATRIX_WIDTH));
	}
	
}