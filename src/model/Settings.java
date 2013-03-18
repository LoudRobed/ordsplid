package model;

public class Settings {
	private int numberOfPlayers, numberOfTurns, turnTime;

	private static Settings instance = null;
	
	private Settings() {
		
	}
	
	public static Settings instance() {
		if (instance == null) instance = new Settings();
		return instance;
	}
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
		System.out.println("Finished set number of players: " + this.numberOfPlayers);
	}

	public void setTurnTime(int turnTime) {
		this.turnTime = turnTime;
		System.out.println("Finished set turntime: " + this.turnTime);
		
	}
	public void setNumberOfTurns() {
		// TODO Auto-generated method stub
		
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public int getTurnTime() {
		return turnTime;
	}

	public int getNumberOfTurns() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}