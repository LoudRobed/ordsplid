package controller;


import java.util.ArrayList;

import model.Dictionary;
import model.Letter;
import model.LetterList;
import model.ScrabbleBag;


public class WordController {

	private static WordController instance = null;
	private Dictionary dictionary = Dictionary.instance();
	private ScrabbleBag bag = new ScrabbleBag();
	
	public boolean checkWord(ArrayList<Letter> word) {
		boolean inDictionary = dictionary.inDictionary(LetterList.listToString(word));
		return inDictionary;
	}
	
	private WordController() {
	}
	
	static public WordController instance() {
		if (instance == null) instance = new WordController();
		return instance;
	}
	
	public int calculateWordScore(ArrayList<Letter> word) {
		int score = 0;
		for (int i = 0; i < word.size(); i++) {
			score += word.get(i).getPoints();
		}
		return score;
	}
	
	/**
	 * Returns the letters used in the word to the ScrabbleBag.
	 * @param word
	 */
	public void returnWordToBag(ArrayList<Letter> word) {
		for (Letter l: word) bag.returnLetter(l);
	}
	
	/**
	 * Removes new letters from the bag.
	 * Do not use this method unless you are planning to return the items later.
	 * @param amount
	 * @return
	 */
	public ArrayList<Letter> retrieveNewLettersFromBag(int amount) {
		ArrayList<Letter> out = new ArrayList<Letter>();
		for (int i = 0; i < amount; i++) {
			out.add(bag.getRandomLetter());
		}
		return out;	
	}
	
	public void resetScrabbleBag() {
		bag = new ScrabbleBag();
	}
	
}