package controller;

import java.util.ArrayList;

import android.content.Intent;

import model.Letter;
import model.LetterList;

import view.GameOverView;
import view.GameView;
import view.SettingsView;


public class GameController {
	private static GameController instance = null;
	private WordController wordController = WordController.instance();
	private PlayerController playerController = PlayerController.instance();
	private boolean ongoingGame = false;
	private int turn = 1;
	
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
	
	public boolean isOngoing() {
		return ongoingGame;
	}
	
	public void newGame() {
		playerController.setNumberOfPlayers(SettingsController.instance().getNumberOfPlayers());
		wordController.resetScrabbleBag();
		
	}
	
	public void updateInfoBar() {
		updateScoreInGameView();
		updatePlayerNameInGameView();
	}
	
	private void updateScoreInGameView() {
		int playerScore = playerController.getScoreForCurrentPlayer();
		GameView.instance().setScore("" + playerScore);
	}
	
	private void updatePlayerNameInGameView() {
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
		updateScoreInGameView();
	}
	
	/**
	 * Starts a new turn for the next player in line
	 */
	public void nextTurn() {
		if (PlayerController.instance().nextPlayer()) {
			if (++turn > SettingsController.instance().getNumberOfTurns()) endGame();
			
		}
		WordController.instance().resetScrabbleBag();
		Intent myIntent = new Intent(GameView.instance(), GameView.class);
		GameView.instance().startActivity(myIntent);
		updateInfoBar();
	}
	
	
	/**
	 * Called when timeout occurs, and the players turn is over
	 */
	public void endTurn() {
		//TODO launch scoreboard
		
	}
	
	
	/**
	 * Called when every round is finished
	 */
	public void endGame() {
		setOngoingGame(false);
		Intent myIntent = new Intent(GameView.instance(), GameOverView.class);
		GameView.instance().startActivity(myIntent);
		GameView.instance().finish();
	}
}