package model;


public class Player implements Comparable<Player> {
	private int score = 0;
	private String name;
	private WordList submittedWords = new WordList();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void incrementScore(int increment) {
		score += increment;
	}
	
	public void addWord(Word word) {
		submittedWords.add(word);
	}
	
	public WordList getWords() {
		return submittedWords;
	}

	
	public String getPlayerInfo() {
		String out = "";
		out += toString() + "\t - \t" + getScore() + " points";
		
		return out;
	}
	

	@Override
	public int compareTo(Player another) {
		return Integer.valueOf(another.getScore()).compareTo(Integer.valueOf(getScore()));
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}