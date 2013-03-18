package view;

import controller.SettingsController;
import model.Settings;
import tdt4240.ordsplid.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class SettingsView extends Activity  {
	static EditText numberOfPlayersField;
	static EditText turnTimeField;
	static Button startGameButton;
	static SettingsView instance;
	
	//Singleton
	public static SettingsView instance() {
		return instance;
	}
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    instance = this;
	    setContentView(R.layout.activity_settings);
	    numberOfPlayersField = (EditText) findViewById(R.id.number_of_players);
	    turnTimeField = (EditText) findViewById(R.id.turn_time);
		startGameButton = (Button) findViewById(R.id.start_game_button);
		startGameButton.setOnClickListener(new SettingsController.ClickListener());

	}
	
	public void startActivity(Class activityClass) {
		Intent myIntent = new Intent(SettingsView.this, activityClass);
		SettingsView.this.startActivity(myIntent);
	}
	
	public static String getNumberOfPlayers() {
		return numberOfPlayersField.getText().toString();
	}
	public static String getTurnTime() {
		return turnTimeField.getText().toString();
	}
}