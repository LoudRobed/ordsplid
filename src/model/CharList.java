package model;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Automatically generated list of characters.
 * Statistics about points and probability are collected from scrabble.
 * 
 * @author Simen
 *
 */
public class CharList {
	private static CharList instance = null;
	
	private ArrayList<Letter> list = new ArrayList<Letter>();
	
	/**
	 * Once initialized, this CharList contains every letter of the english alphabet, with probabilities and points.
	 */
	private CharList() {
		fillList();
	}
	
	/**
	 * Will return the singleton object, if no such object exists, one will be created.
	 * @return
	 */
	static public CharList instance() {
		if (instance == null) instance = new CharList();
		return instance;
	}
	
	/**
	 * Only adds if the letter does not already exist.
	 */
	private boolean add(Letter l) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).compareTo(l) == 0) {
				System.err.println("Letter already exists");
				return false;
			}
		}
		add(l);
		return true;
	}
	
	/**
	 * Takes a Character and returns the letter object corresponding to the input object
	 * @param c
	 * @return
	 */
	public Letter get(Character c) {
		return list.get((int) c.charValue() - 97);
	}

	
	/**
	 * Returns the Letter object at the given index
	 * @param i
	 * @return
	 */
	public Letter get(int i) {
		return list.get(i);
	}
	
	private void fillList() {
		//1 point
		add(new Letter('a',9,1));
		add(new Letter('e',12,1));
		add(new Letter('i',9,1));
		add(new Letter('l',4,1));
		add(new Letter('n',6,1));
		add(new Letter('o',8,1));
		add(new Letter('r',6,1));
		add(new Letter('s',4,1));
		add(new Letter('t',6,1));
		add(new Letter('u',4,1));
		
		//2 points
		add(new Letter('d',4,2));
		add(new Letter('g',3,2));
		
		//3 points
		add(new Letter('b',2,3));
		add(new Letter('c',2,3));
		add(new Letter('m',2,3));
		add(new Letter('p',2,3));
		
		//4 points
		add(new Letter('f',2,4));
		add(new Letter('h',2,4));
		add(new Letter('v',2,4));
		add(new Letter('w',2,4));
		add(new Letter('y',2,4));
		
		//5 points
		add(new Letter('k',1,5));

		//8 points
		add(new Letter('j',1,8));
		add(new Letter('x',1,8));
		
		//10 points
		add(new Letter('q',1,10));
		add(new Letter('z',1,10));
		
		Collections.sort(list);
		if (list.size() != 26) System.err.println("Freak out! Missing letters");
	}		
}

/**
 * Letter class. Contains information about each letter
 * @author Simen
 *
 */
class Letter implements Comparable<Letter> {
	int probability, points, maxOnBoard;
	Character letter;
	
	Letter(char letter, int probability, int points) {
		this.letter = letter;
		this.probability = probability;
		this.maxOnBoard = probability;
		this.points = points;
	}

	public int compareTo(Letter another) {
		return this.letter.compareTo(((Letter) another).letter);
	}
	
	public String toString() {
		return letter + " - Probability: " + probability + "% - Points: " + points;
	}
}
