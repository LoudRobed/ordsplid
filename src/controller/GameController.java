package controller;

import java.util.ArrayList;

import model.Letter;
import model.LetterList;

import view.GameView;


public class GameController {
	private static GameController instance = null;
	private WordController wordController = WordController.instance();
	private PlayerController playerController = PlayerController.instance();
	
	public static GameController instance() {
		if (instance == null) instance = new GameController();
		return instance;
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
	
	
	
}