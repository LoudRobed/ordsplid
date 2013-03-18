package controller;

import java.util.ArrayList;

import model.Player;


/**
 * Only test
 * @author Simen
 *
 */
public class PlayerController {
	private ArrayList<Player> players = null;
	private Player currentPlayer = null;
	private static PlayerController instance;
	
	private PlayerController() {}
	
	public static PlayerController instance() {
		if (instance == null) instance = new PlayerController();
		return instance;
	}
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		players = new ArrayList<Player>();
		if (numberOfPlayers <= 0) return;
		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new Player());
		}
		currentPlayer = players.get(0);
	}
	
	public void setNames(String[] names) {
	}
	
	public int getScoreForCurrentPlayer() {
		if (currentPlayer == null) return -1;
		return currentPlayer.getScore();
	}
	
	public void updateScoreOfCurrentPlayer(int increment) {
		currentPlayer.incrementScore(increment);
	}
	
	public void nextPlayer() {
		int index = players.indexOf(currentPlayer);
		if (index >= players.size() - 1) index = 0;
		else index++;
		
		currentPlayer = players.get(index);
	}
}