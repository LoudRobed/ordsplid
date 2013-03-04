package view;

import tdt4240.ordsplid.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity  {

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_ordsplid);
	    
		Button newGameButton = (Button) findViewById(R.id.new_game_button);
		Button settingsButton = (Button) findViewById(R.id.settings_button);
		
		//newGameButton.setOnClickListener(l)

	}
}