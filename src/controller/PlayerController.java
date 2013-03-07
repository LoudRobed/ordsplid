package controller;

import java.util.ArrayList;

import model.Player;

public class PlayerController {
	ArrayList<Player> players = new ArrayList<Player>();
	Player currentPlayer = null;
	
	PlayerController(int numberOfPlayers) {
		if (numberOfPlayers <= 0) return;
		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new Player());
		}
		currentPlayer = players.get(0);
	}
	
	public void setNames(String[] names) {
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