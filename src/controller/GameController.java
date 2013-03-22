package controller;

import java.util.ArrayList;

import android.content.Intent;

import model.Letter;
import model.LetterList;
import model.Word;

import view.GameOverView;
import view.GameOverView;
import view.GameView;
import view.SettingsView;


public class GameController {
	private static GameController instance = null;
	private WordController wordController = WordController.instance();
	private PlayerController playerController = PlayerController.instance();
	private boolean ongoingGame = false;
	private int currentTurn;
	
	private GameController() {}
	
	public static GameController instance() {
		if (instance == null) instance = new GameController();
		return instance;
	} 
	
	/**
	 * Starts a new turn for the next player in line
	 */
	public void nextTurn() {
		if (PlayerController.instance().nextPlayer()) {
			if (++currentTurn > SettingsController.instance().getNumberOfTurns()){
				endGame();
				return;
			}
			
		}
		WordController.instance().resetScrabbleBag();
		Intent myIntent = new Intent(GameView.instance(), GameView.class);
		
		GameView temp = GameView.instance();
		temp.startActivity(myIntent);
		temp.finish();
		updateInfoBarInGameView();
	}
	
	/**
	 * Called when timeout occurs, and the players turn is over
	 */
	public void endTurn() {
		//TODO launch scoreboard
		
		nextTurn();
	}


	public void newGame() {
		playerController.setNumberOfPlayers(SettingsController.instance().getNumberOfPlayers());
		wordController.resetScrabbleBag();
		currentTurn = 1;
		
	}
	
	public void endGame() {
		setOngoingGame(false);
		
		Intent myIntent = new Intent(GameView.instance(), GameOverView.class);
		GameView.instance().startActivity(myIntent);
		GameView.instance().finish();
	}
	
	public void submitWord(Word word) {
		int wordScore = word.getWordScore();
		
		wordController.returnWordToBag(word);
		playerController.addWordToCurrentPlayer(word);
		
		word = wordController.retrieveNewLettersFromBag(word.size());
		GameView.instance().switchLetters(word);
		GameView.instance().displayToast("Word score: " + wordScore);
		updateScoreInGameView();
	}
	
	public void updateInfoBarInGameView() {
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

	public void setOngoingGame(boolean bool) {
		if (bool && !ongoingGame) {
			newGame();
		}
		ongoingGame = bool;
	}
	
	public boolean isOngoing() {
		return ongoingGame;
	}
	
	public int getCurrentTurn() {
		return currentTurn;
	}
}