package view;

import tdt4240.ordsplid.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class GameView extends Activity{
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_game_view);
	    
	    Button ok = (Button)findViewById(R.id.game_ok_button);
	    final EditText text = (EditText)findViewById(R.id.resultString);
	    
	    ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				text.setText("ok clicked");
			}
		});
	}
}
