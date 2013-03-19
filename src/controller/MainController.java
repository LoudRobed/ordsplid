package controller;

import android.content.Context;

public class MainController {
	private static MainController instance = null;
	
	private MainController() {}
	
	public static MainController instance() {
		if (instance == null) return new MainController();
		return instance;
	}
	
	public void onStartup(Context context) {
		WordController.instance().buildDictionary(context);
	    GameController.instance().setOngoingGame(false);

	}
}