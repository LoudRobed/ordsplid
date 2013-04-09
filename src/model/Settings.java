package model;



public class Settings {
	private int numberOfPlayers, numberOfTurns, turnTime;

	public Settings() {
		
	}
		
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public void setTurnTime(int turnTime) {
		this.turnTime = turnTime;
		
	}
	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public int getTurnTime() {
		return turnTime;
	}

	public int getNumberOfTurns() {
		return numberOfTurns;
	}
	
	
}