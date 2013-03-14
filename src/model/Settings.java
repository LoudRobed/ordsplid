package model;

public class Settings {
	private static int numberOfPlayers, numberOfTurns, turnTime;

	public static void setNumberOfPlayers(int numberOfPlayers) {
		Settings.numberOfPlayers = numberOfPlayers;
	}

	public static void setTurnTime(int turnTime) {
		Settings.turnTime = turnTime;
		
	}
	public static void setNumberOfTurns() {
		// TODO Auto-generated method stub
		
	}

	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public static int getTurnTime() {
		return turnTime;
	}

	public static int getNumberOfTurns() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}