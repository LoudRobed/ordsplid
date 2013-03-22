package model;

import java.util.ArrayList;

public class Player implements IPlayer, Comparable<Player> {
	private int score = 0;
	private String name;
	private ArrayList<Word> submittedWords = new ArrayList<Word>();
	
	public Player(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void incrementScore(int increment) {
		score += increment;
	}
	
	public void addWord(Word word) {
		submittedWords.add(word);
	}
	
	public ArrayList<Word> getWords() {
		return submittedWords;
	}

	@Override
	public int compareTo(Player another) {
		return Integer.valueOf(getScore()).compareTo(Integer.valueOf(another.getScore()));
	}
	
	
}