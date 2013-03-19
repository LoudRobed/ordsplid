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
	
	public void updateInfoBar() {
		updateScoreInView();
		updatePlayerNameInView();
	}
	
	private void updateScoreInView() {
		int playerScore = playerController.getScoreForCurrentPlayer();
		
		GameView.instance().setScore("" + playerScore);
	}
	
	private void updatePlayerNameInView() {
		String name = PlayerController.instance().getNameOfCurrentPlayer();
		
		GameView.instance().setPlayerName(name);
	}
	
	

	public void submitWord(ArrayList<Letter> word) {
		int wordScore = wordController.calculateWordScore(word);
		wordController.returnWordToBag(word);
		playerController.updateScoreOfCurrentPlayer(wordScore);
		
		word = wordController.retrieveNewLettersFromBag(word.size());
		GameView.instance().switchLetters(word);
		GameView.instance().displayToast("Wordscore: " + wordScore);
		updateScoreInView();
	}
	
	/**
	 * Starts a new round for the next player in line
	 */
	public void nextRound() {
		PlayerController.instance().nextPlayer();
		WordController.instance().resetScrabbleBag();
		Intent myIntent = new Intent(GameView.instance(), GameView.class);
		GameView.instance().startActivity(myIntent);
		updateInfoBar();
	}
	
	
	/**
	 * Called when timeout occurs, and the players turn is over
	 */
	public void endRound() {
		//TODO launch scoreboard
		
		nextRound();
	}
	
	
	
	
}