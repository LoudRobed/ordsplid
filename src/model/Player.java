package model;

public class Player implements IPlayer {
	private int score = 0;
	private String name;
	
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
	
	
}