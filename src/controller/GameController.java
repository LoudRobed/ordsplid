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
		if (bool && !ongoingGame) {
			newGame();
		}
		ongoingGame = bool;
	}
	
	public void newGame() {
		playerController.setNumberOfPlayers(SettingsController.instance().getNumberOfPlayers());
		wordController.resetScrabbleBag();
	}

	public void submitWord(ArrayList<Letter> word) {
		int wordScore = wordController.calculateWordScore(word);
		wordController.returnWordToBag(word);
		playerController.updateScoreOfCurrentPlayer(wordScore);
		
		int playerScore = playerController.getScoreForCurrentPlayer();
		String name = PlayerController.instance().getNameOfCurrentPlayer();
		word = wordController.retrieveNewLettersFromBag(word.size());
		GameView.instance().switchLetters(word);
		GameView.instance().displayToast(name + "\nWordscore: " + wordScore + "\nTotal score: " + playerScore);
	}
	
	/**
	 * Starts a new round for the next player in line
	 */
	public void nextRound() {
		PlayerController.instance().nextPlayer();
		WordController.instance().resetScrabbleBag();
		Intent myIntent = new Intent(GameView.instance(), GameView.class);
		GameView.instance().startActivity(myIntent);
	}
	
	
	/**
	 * Called when timeout occurs, and the players turn is over
	 */
	public void endRound() {
		//TODO launch scoreboard
		
		nextRound();
	}
	
	
	
}