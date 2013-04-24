package view;

import tdt4240.ordsplid.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import controller.SettingsController;


public class SettingsView extends Activity  {
	private EditText numberOfPlayersField, turnTimeField, numberOfTurnsField;
	private Button startGameButton;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_settings);
	    
	    numberOfPlayersField = (EditText) findViewById(R.id.number_of_players_field);
	    turnTimeField = (EditText) findViewById(R.id.turn_time_field);
	    numberOfTurnsField = (EditText) findViewById(R.id.number_of_turns_field);
		startGameButton = (Button) findViewById(R.id.start_game_button);
		startGameButton.setOnClickListener(new SettingsController.SettingsViewButtonListener(this));
		
		fillFields();
	}
	
	public void fillFields() {
		numberOfPlayersField.setText(Integer.toString(SettingsController.instance().getNumberOfPlayers()));
		numberOfTurnsField.setText(Integer.toString(SettingsController.instance().getNumberOfTurns()));
		turnTimeField.setText(Integer.toString(SettingsController.instance().getTurnTime()));
	}
	
	public String getNumberOfPlayers() {
		return numberOfPlayersField.getText().toString();
	}
	public String getTurnTime() {
		return turnTimeField.getText().toString();
	}
	public String getNumberOfTurns() {
		return numberOfTurnsField.getText().toString();
	}
	
	public void displayToast(String text) {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
}