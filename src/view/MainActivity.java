package view;

import controller.GameController;
import controller.MainController;
import controller.PlayerController;
import controller.SettingsController;
import controller.WordController;
import model.Dictionary;
import tdt4240.ordsplid.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity  {

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.activity_ordsplid);
	    
	    
		MainController.instance().onStartup(getApplicationContext());
	    
	    
		Button newGameButton = (Button) findViewById(R.id.new_game_button);
		Button settingsButton = (Button) findViewById(R.id.settings_button);
		
		
		
		newGameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, GameView.class);
				MainActivity.this.startActivity(myIntent);
			}
		});
		
		settingsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, SettingsView.class);
				MainActivity.this.startActivity(myIntent);
			}
		});


	}
}