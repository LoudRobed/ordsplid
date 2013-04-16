package controller;

import model.Settings;
import view.SettingsView;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;

public class SettingsController {
	private static Settings settings;
	private static SettingsController instance = null;
	
	private SettingsController() {
		settings = new Settings();
		settings.setNumberOfPlayers(1);
		settings.setNumberOfTurns(3);
		settings.setTurnTime(30);
	}
	
	static public SettingsController instance() {
		if (instance == null) instance = new SettingsController();
		return instance;
	}
	
	public void readSettingsFromStorage(Context context) {
		SharedPreferences preferences = context.getSharedPreferences("settings",0);
		settings.setNumberOfPlayers(preferences.getInt("numberOfPlayers", 1));
		settings.setNumberOfTurns(preferences.getInt("numberOfTurns", 3));
		settings.setTurnTime(preferences.getInt("turnTime", 30));
	}
	
	
	
	public void writeSettingsToStorage(Context context) {
		SharedPreferences preferences = context.getSharedPreferences("settings",0);
		Editor edit = preferences.edit();
		edit.putInt("numberOfPlayers", settings.getNumberOfPlayers());
		edit.putInt("numberOfTurns", settings.getNumberOfTurns());
		edit.putInt("turnTime", settings.getTurnTime());
		edit.apply();
	}
	
	static public class SettingsViewButtonListener implements OnClickListener {
		public void onClick(View v) {
			
			try {
				int numberOfPlayers = Integer.parseInt(SettingsView.instance().getNumberOfPlayers());
				settings.setNumberOfPlayers(numberOfPlayers);
			} catch(NumberFormatException e) {}
			
			try {
				int turnTime = Integer.parseInt(SettingsView.instance().getTurnTime());
				settings.setTurnTime(turnTime);
			} catch(NumberFormatException e) {}
			
			try {
				int numberOfTurns = Integer.parseInt(SettingsView.instance().getNumberOfTurns());
				settings.setNumberOfTurns(numberOfTurns);
			} catch(NumberFormatException e) {}
			
			
			
			SettingsController.instance().writeSettingsToStorage(SettingsView.instance());
			SettingsView.instance().finish();
						
		}
	}
	
	public int getNumberOfPlayers() {
		return settings.getNumberOfPlayers();
	}
	
	public int getTurnTime() {
		return settings.getTurnTime();
	}
	
	public int getNumberOfTurns() {
		return settings.getNumberOfTurns();
	}
	
}