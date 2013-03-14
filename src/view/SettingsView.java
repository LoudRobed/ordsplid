package view;

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

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_settings);
	    
		final EditText numberOfPlayersField = (EditText) findViewById(R.id.number_of_players);
		final EditText turnTimeField = (EditText) findViewById(R.id.turn_time);
		
		Button startGameButton = (Button) findViewById(R.id.start_game_button);
		
		startGameButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int numberOfPlayers = Integer.parseInt(numberOfPlayersField.getText().toString());
				int turnTime = Integer.parseInt(turnTimeField.getText().toString());
				Settings.setNumberOfPlayers(numberOfPlayers);
				Settings.setTurnTime(turnTime);
				
				Intent myIntent = new Intent(SettingsView.this, MainActivity.class);
				SettingsView.this.startActivity(myIntent);
			}
		});
		
		//newGameButton.setOnClickListener(l)

	}
}