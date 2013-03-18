package view;

import java.util.ArrayList;

import model.Letter;
import tdt4240.ordsplid.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import controller.WordController;

public class GameView extends Activity{
	private ButtonAdapter btnAdapter;
	private String s = "";
	private WordController wController = new WordController();
	private ArrayList<Letter> currentWord = new ArrayList<Letter>();
	
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_game_view);
	    
	    btnAdapter = new ButtonAdapter(this);
	    
	    final EditText text = (EditText)findViewById(R.id.resultString);
	    
	    //Setting up the OK button
	    final Button ok = (Button)findViewById(R.id.game_ok_button);
	    ok.setText("OK");
	    ok.setBackgroundColor(Color.RED);
	  
	    //Setting the GridView and adapter
	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(btnAdapter);

	    //ClickListener for the buttons in the matrix
	    btnAdapter.setOnButtonClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Button temp = (Button) v;
				s += temp.getText();
				currentWord.add(btnAdapter.getInUseList().get(temp.getId()));
				text.setText(s);
				if(!wController.checkWord(currentWord)){
					ok.setBackgroundColor(Color.RED);
				}else{
					ok.setBackgroundColor(Color.GREEN);
				}
			}
		});
	    
//	    gridview.setOnItemClickListener(new OnItemClickListener() {
//	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//	        }
//	    });
	    
	    //ClickListener for the OK button
	    ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Check if the word is allowed
				if(wController.checkWord(currentWord)){
					text.setText("word exists");
					s = "";
				}else{
					text.setText("wrong word");
					s = "";
				}
			}
		});
	}
}
