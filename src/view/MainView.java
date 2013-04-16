package view;

import tdt4240.ordsplid.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import controller.MainController;

public class MainView extends Activity  {
	private ProgressBar bar;
	boolean finishedLoading = false;
	private Handler handler = new Handler();
	private Button newGameButton;
	private Button settingsButton;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.activity_ordsplid);
	    
	    bar = (ProgressBar) findViewById(R.id.progress_large);;
	      
		new Thread(new Runnable() {
	        public void run() {     	
	        	MainController.instance().onStartup(getApplicationContext());
	        	handler.post(new Runnable() {
					@Override
					public void run() {
						finishedLoading();
					}
	        	});
	        }
	    }).start();
	    
		newGameButton = (Button) findViewById(R.id.new_game_button);
		settingsButton = (Button) findViewById(R.id.settings_button);
		
		newGameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainView.this, GameView.class);
				MainView.this.startActivity(myIntent);
			}
		});
		newGameButton.setVisibility(View.INVISIBLE);
		
		settingsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainView.this, SettingsView.class);
				MainView.this.startActivity(myIntent);
			}
		});
		settingsButton.setVisibility(View.INVISIBLE);
	}
	
	private void finishedLoading() {
		bar.setVisibility(View.INVISIBLE);
		newGameButton.setVisibility(View.VISIBLE);
		settingsButton.setVisibility(View.VISIBLE);
	}
}