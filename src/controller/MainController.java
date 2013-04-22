package controller;

import android.content.Context;

public class MainController {
	private static MainController instance = null;
	
	private MainController() {}
	
	public static MainController instance() {
		if (instance == null) return new MainController();
		return instance;
	}
	
	/**
	 * Creates a new dictionary for the game and imports the settings
	 * @param context
	 */
	public void onStartup(Context context) {
		WordController.instance().buildDictionary(context);
		SettingsController.instance().readSettingsFromStorage(context);
	}
}