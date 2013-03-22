package model;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Class that contains all the different letters used in the game.
 * Statistics about points and probability are collected from scrabble.
 * 
 * @author Simen
 *
 */
public class LetterList {
	private static LetterList instance = null;
	
	private ArrayList<Letter> list = new ArrayList<Letter>();
	
	/**
	 * Once initialized, this CharList contains every letter of the english alphabet, with probabilities and points.
	 */
	private LetterList() {
		fillList();
	}
	
	/**
	 * Will return the singleton object, if no such object exists, one will be created.
	 * @return
	 */
	static public LetterList instance() {
		if (instance == null) instance = new LetterList();
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
		list.add(l);
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
		add(Letter.createLetter('a',9,1));
		add(Letter.createLetter('e',12,1));
		add(Letter.createLetter('i',9,1));
		add(Letter.createLetter('l',4,1));
		add(Letter.createLetter('n',6,1));
		add(Letter.createLetter('o',8,1));
		add(Letter.createLetter('r',6,1));
		add(Letter.createLetter('s',4,1));
		add(Letter.createLetter('t',6,1));
		add(Letter.createLetter('u',4,1));
		
		//2 points
		add(Letter.createLetter('d',4,2));
		add(Letter.createLetter('g',3,2));
		
		//3 points
		add(Letter.createLetter('b',2,3));
		add(Letter.createLetter('c',2,3));
		add(Letter.createLetter('m',2,3));
		add(Letter.createLetter('p',2,3));
		
		//4 points
		add(Letter.createLetter('f',2,4));
		add(Letter.createLetter('h',2,4));
		add(Letter.createLetter('v',2,4));
		add(Letter.createLetter('w',2,4));
		add(Letter.createLetter('y',2,4));
		
		//5 points
		add(Letter.createLetter('k',1,5));

		//8 points
		add(Letter.createLetter('j',1,8));
		add(Letter.createLetter('x',1,8));
		
		//10 points
		add(Letter.createLetter('q',1,10));
		add(Letter.createLetter('z',1,10));
		
		Collections.sort(list);
		if (list.size() != Constants.NUMBER_OF_DISTINCT_LETTERS)
			System.err.println("Freak out! Missing letters");
	}		
}
