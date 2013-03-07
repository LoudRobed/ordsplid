package controller;

import java.util.ArrayList;

import model.Letter;

public interface IWordController {
	public boolean checkWord(ArrayList<Letter> word);
	
	public int calculateWordScore(ArrayList<Letter> word);
	
	public void returnWordToBag(ArrayList<Letter> word);

	public ArrayList<Letter> retrieveNewLettersFromBag(int amount);
}
