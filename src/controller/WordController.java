package controller;


import model.Dictionary;
import model.Letter;
import model.ScrabbleBag;
import model.Word;
import android.content.Context;


public class WordController {

	private static WordController instance = null;
	private Dictionary dictionary;
	private ScrabbleBag bag = new ScrabbleBag();
	
	/**
	 * Checks if the written word exists in the dictionary
	 * @param word
	 * @return true or false
	 */
	public boolean checkWord(Word word) {
		boolean inDictionary = dictionary.inDictionary(word.toString());
		return inDictionary;
	}
	
	private WordController() {}
	
	static public WordController instance() {
		if (instance == null) instance = new WordController();
		return instance;
	}
	
	
	/**
	 * Returns the letters used in the word to the ScrabbleBag.
	 * @param word
	 */
	public void returnWordToBag(Word word) {
		for (Letter l: word) bag.returnLetter(l);
	}
	
	/**
	 * Removes new letters from the bag.
	 * Do not use this method unless you are planning to return the items later.
	 * @param amount
	 * @return
	 */
	public Word retrieveNewLettersFromBag(int amount) {
		Word out = new Word();
		for (int i = 0; i < amount; i++) {
			out.add(bag.getRandomLetter());
		}
		return out;	
	}
	
	public void resetScrabbleBag() {
		bag = new ScrabbleBag();
	}
	
	public void buildDictionary(Context context) {
		dictionary = new Dictionary(context);
	}
	
}