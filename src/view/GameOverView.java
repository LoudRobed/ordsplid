package view;

import tdt4240.ordsplid.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameOverView extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.activity_game_over);
	    
	    Button backButton = (Button) findViewById(R.id.game_over_button);
	    
	    backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				GameOverView.super.finish();
				
			}
	    	
	    });

	}
}