package controller;

import model.Settings;
import tdt4240.ordsplid.R;
import view.GameView;
import view.MainActivity;
import view.SettingsView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsController {
	private static Settings settings = Settings.instance();
	private static SettingsController instance = null;
	
	private SettingsController() {}
	
	static public SettingsController instance() {
		if (instance == null) instance = new SettingsController();
		return instance;
	}
	
	static public class SettingsViewButtonListener implements OnClickListener {
		public void onClick(View v) {
			
			try {
				int numberOfPlayers = Integer.parseInt(SettingsView.getNumberOfPlayers());
				int turnTime = Integer.parseInt(SettingsView.getTurnTime());
				settings.setNumberOfPlayers(numberOfPlayers);
				settings.setTurnTime(turnTime);
				SettingsView.instance().startActivity(GameView.class);
			}
			catch (NumberFormatException e) {
				SettingsView.instance().displayToast("Please enter number");
				e.printStackTrace();
			}
						
		}
	}
	
}