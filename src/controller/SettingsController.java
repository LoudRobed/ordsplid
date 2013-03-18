package controller;

import model.Settings;
import tdt4240.ordsplid.R;
import view.MainActivity;
import view.SettingsView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SettingsController {
	static Settings settings = Settings.instance();
	
	public SettingsController() {
			
	}
	
	static public class ClickListener implements OnClickListener {
		public void onClick(View v) {
			int numberOfPlayers = Integer.parseInt(SettingsView.getNumberOfPlayers());
			int turnTime = Integer.parseInt(SettingsView.getTurnTime());
			
			settings.setNumberOfPlayers(numberOfPlayers);
			settings.setTurnTime(turnTime);
			
			SettingsView.instance().startActivity(MainActivity.class);
			
		}
	}
}