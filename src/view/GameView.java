package view;

import tdt4240.ordsplid.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

public class GameView extends Activity{
	private ButtonAdapter btnAdapter;
	private String s = "";
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_game_view);
	    
	    btnAdapter = new ButtonAdapter(this);
	    
	    final EditText text = (EditText)findViewById(R.id.resultString);
	    Button ok = (Button)findViewById(R.id.game_ok_button);
	    ok.setText("OK");
	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(btnAdapter);

	    btnAdapter.setOnButtonClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Button temp = (Button) v;
				s += temp.getText();
				text.setText(s);
			}
		});
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        }
	    });
	}
}
