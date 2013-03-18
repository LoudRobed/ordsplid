package controller;

public abstract class IGameController {
	int time;
	
	abstract void newGame();
	
	abstract void startGame();
	
	abstract void switchPlayer();
	
	abstract void updateScore();//PlayerController.updateScore();
		
	
	abstract void endGame(); //launch dialog with scores
	
	
	
	
	
}
