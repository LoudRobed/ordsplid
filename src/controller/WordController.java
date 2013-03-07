package controller;


import java.util.ArrayList;

import model.Dictionary;
import model.Letter;
import model.LetterList;
import model.ScrabbleBag;


public class WordController {

	private static Dictionary dictionary = Dictionary.instance();
	private static LetterList letterList = LetterList.instance();
	private static ScrabbleBag bag = ScrabbleBag.instance();
	
	public static boolean checkWord(ArrayList<Letter> word) {
		return dictionary.inDictionary(LetterList.listToString(word));
	}
	
	public static int calculateWordScore(ArrayList<Letter> word) {
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
	public static void returnWordToBag(ArrayList<Letter> word) {
		for (Letter l: word) bag.returnLetter(l);
	}
	
	/**
	 * Removes new letters from the bag.
	 * Do not use this method unless you are planning to return the items later.
	 * @param amount
	 * @return
	 */
	public static ArrayList<Letter> retrieveNewLettersFromBag(int amount) {
		ArrayList<Letter> out = new ArrayList<Letter>();
		for (int i = 0; i < amount; i++) {
			out.add(bag.getRandomLetter());
		}
		return out;	
	}
	
}