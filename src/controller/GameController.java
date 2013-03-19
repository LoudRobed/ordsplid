package controller;

import java.util.ArrayList;

import android.content.Intent;

import model.Letter;
import model.LetterList;

import view.GameView;
import view.SettingsView;


public class GameController {
	private static GameController instance = null;
	private WordController wordController = WordController.instance();
	private PlayerController playerController = PlayerController.instance();
	private boolean ongoingGame = false;
	
	public static GameController instance() {
		if (instance == null) instance = new GameController();
		return instance;
	} 
	
	private GameController() {}
	
	public void setOngoingGame(boolean bool) {
		if (bool && !ongoingGame) newGame();
		else ongoingGame = bool;
	}
	
	public void newGame() {
		playerController.setNumberOfPlayers(1);
		wordController.resetScrabbleBag();
	}

	public void submitWord(ArrayList<Letter> word) {
		int wordScore = wordController.calculateWordScore(word);
		wordController.returnWordToBag(word);
		playerController.updateScoreOfCurrentPlayer(wordScore);
		
		int playerScore = playerController.getScoreForCurrentPlayer();
		
		word = wordController.retrieveNewLettersFromBag(word.size());
		GameView.instance().switchLetters(word);
		GameView.instance().displayToast("Wordscore: " + wordScore + "\nTotal score: " + playerScore);
	}
	
	/**
	 * Called by scoreboard to continue with the next player
	 */
	public void nextPlayer() {
		Intent myIntent = new Intent(GameView.instance(), GameView.class);
		GameView.instance().startActivity(myIntent);
	}
	
	
	/**
	 * Called when timeout occurs, and the players turn is over
	 */
	public void showIntermission() {
		//TODO launch scoreboard
		
		
		//Only temporary until scoreboard is completed.
		nextPlayer();
	}
	
	
	
}