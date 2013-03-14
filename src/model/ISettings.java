package model;

public interface ISettings {
	public void setNumberOfPlayers();
	public void setTurnTime();
	public void setNumberOfTurns();
	
	public int getNumberOfPlayers();
	public int getTurnTime();
	public int getNumberOfTurns();
}