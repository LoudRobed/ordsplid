package controller;

import java.util.ArrayList;

import model.Letter;

public class GameController implements IGameController {
	
	public void pressedOK(ArrayList<Letter> word) {
		if (WordController.checkWord(word)) {
			int score = WordController.calculateWordScore(word);
			
		}
		else {}
	}
}