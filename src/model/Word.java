package model;

import java.util.ArrayList;

public class Word extends ArrayList<Letter> {

	public Word(ArrayList<Letter> word) {
		 for (Letter letter : word) {
			 add(letter);
		 }
	}
	
	public Word(String word) {
		Word temp = stringToWord(word);
		for (Letter letter : temp) {
			add(letter);
		}
	}
	
	public Word() {}
	
	
	private Word stringToWord(String input) {
		Word out = new Word();
		for (int i = 0; i < input.length(); i++) {
			out.add(LetterList.instance().get(Character.valueOf(input.charAt(i))));
		}
		return out;
	}
	
	/**
	 * Calculates the score of the written word
	 * @return int score
	 */
	public int getWordScore() {
		int score = 0;
		for (int i = 0; i < size(); i++) {
			score += get(i).getPoints();
		}
		return score;
	}
	
	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < size(); i++) {
			out += get(i).toString();
		}
		return out;
	}

	public String getInfo() {
		String out = "";
		out += toString() + " - ";
		out += getWordScore() + " points - ";
		out += size() + " letters ";
		
		return out;
	}
}