package model;

public class Player implements IPlayer {
	private int score = 0;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
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