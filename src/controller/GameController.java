package controller;

import model.Word;
import view.GameOverView;
import view.GameView;
import view.ScoreDialog;
import android.content.Intent;


public class GameController {
	private static GameController instance = null;
	private WordController wordController = WordController.instance();
	private PlayerController playerController = PlayerController.instance();
	private GameView gameView;
	private boolean ongoingGame = false;
	private int currentTurn;
	
	private GameController() {}
	
	/**
	 * Singleton instantiation
	 * @return GameController object
	 */
	public static GameController instance() {
		if (instance == null) instance = new GameController();
		return instance;
	} 
	
	public void setGameView(GameView view) {
		gameView = view;
	} 
	
	/**
	 * Starts a new turn for the next player in line
	 */
	public void nextTurn() {
		
		WordController.instance().resetScrabbleBag();
		Intent myIntent = new Intent(gameView, GameView.class);
		
		GameView temp = gameView;
		temp.startActivity(myIntent);
		temp.finish();
		updateInfoBarInGameView();
	}
	
	/**
	 * Called when timeout occurs, and the players turn is over
	 */
	public void endTurn() {
		if (PlayerController.instance().nextPlayer()) {
			if (++currentTurn > SettingsController.instance().getNumberOfTurns()){
				endGame();
				return;
			}
			
		}
		ScoreDialog scoreDialog = new ScoreDialog(gameView);
		scoreDialog.show();
	}

	public void newGame() {
		playerController.setNumberOfPlayers(SettingsController.instance().getNumberOfPlayers());
		wordController.resetScrabbleBag();
		currentTurn = 1;
	}
	
	public void endGame() {
		setOngoingGame(false);
		
		Intent myIntent = new Intent(gameView, GameOverView.class);
		gameView.startActivity(myIntent);
		gameView.finish();
	}
	
	/**
	 * Submits the written word, updates the score, switches the letter in the matrix and returns the used letters to the scrabblebag
	 * @param word the written word
	 */
	public void submitWord(Word word) {
		int wordScore = word.getWordScore();
		
		wordController.returnWordToBag(word);
		playerController.addWordToCurrentPlayer(word);
		
		word = wordController.retrieveNewLettersFromBag(word.size());
		gameView.switchLetters(word);
		gameView.displayToast("Word score: " + wordScore);
		updateScoreInGameView();
	}
	
	/**
	 * Updates the scoredisplay and playerdisplay
	 */
	public void updateInfoBarInGameView() {
		updateScoreInGameView();
		updatePlayerNameInGameView();
	}
	
	private void updateScoreInGameView() {
		int playerScore = playerController.getScoreForCurrentPlayer();
		gameView.setScore("" + playerScore);
	}
	
	private void updatePlayerNameInGameView() {
		String name = PlayerController.instance().getNameOfCurrentPlayer();
		
		gameView.setPlayerName(name);
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
