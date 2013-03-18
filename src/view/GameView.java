package view;

import java.util.ArrayList;

import model.Letter;
import tdt4240.ordsplid.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;
import controller.GameController;
import controller.WordController;

public class GameView extends Activity{
	static private GameView instance;
	
	public static GameView instance() {
		return instance;
	}
	
	private ButtonAdapter btnAdapter;
	private String s = "";
	private WordController wController = WordController.instance();
	private ArrayList<Letter> currentWord = new ArrayList<Letter>();
	private Button prevClickedBtn;
	private ArrayList<MatrixButton> activeButtons;
	private Button ok; 
	
    private EditText text;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    instance = this;
	    
	    GameController.instance().newGame();
	    
	    
	    setContentView(R.layout.activity_game_view);
	    
	    activeButtons = new ArrayList<MatrixButton>();
	    btnAdapter = new ButtonAdapter(this);
	    text = (EditText)findViewById(R.id.resultString);
	    
	    //Setting up the OK button
	    ok = (Button)findViewById(R.id.game_ok_button);
	    
	    updateOKButton();
	  
	    //Setting the GridView and adapter
	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(btnAdapter);

	    //ClickListener for the buttons in the matrix
	    btnAdapter.setOnButtonClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				MatrixButton temp = (MatrixButton) v;
				
				if (activeButtons.size() > 0 && activeButtons.get(activeButtons.size() - 1) == temp) {
					currentWord.remove(currentWord.size() - 1);
					activeButtons.remove(temp);
					s = s.substring(0, s.length() - 1);
					text.setText(s);
					temp.setBackgroundColor(Color.LTGRAY);
					if (activeButtons.size() > 0) {
						prevClickedBtn = activeButtons.get(activeButtons.size() - 1);
						prevClickedBtn.setBackgroundColor(Color.YELLOW);
					}
					
				}
				else if (activeButtons.contains(temp)) {
					return;
				}
				else {
					s += temp.getText();
					currentWord.add(temp.getLetter());
					activeButtons.add(temp);
					text.setText(s);
					temp.setBackgroundColor(Color.YELLOW);
					
					if(s.length() > 1){
						prevClickedBtn.setBackgroundColor(Color.BLUE);
					}
					prevClickedBtn = temp;
				}
				updateOKButton();
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
					GameController.instance().submitWord(currentWord);
					//text.setText("word exists");
					
					//s = "";
				}else{
					//text.setText("wrong word");
					//s = "";
				}
				clearScreen();
			}
		});
	}
	
	private void updateOKButton() {
		if(!wController.checkWord(currentWord)){
			ok.setBackgroundColor(Color.RED);
			ok.setText("Erase word");
		}else{
			ok.setBackgroundColor(Color.GREEN);
			ok.setText("Submit");
		}
	}
	
	public void displayToast(String text) {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.setGravity(Gravity.TOP, 0, 130);
		toast.show();
	}
	
	public void switchLetters(ArrayList<Letter> newLetters) {
		if (activeButtons.size() != newLetters.size()){
			displayToast("ERROR! Sizes does not match\n" + activeButtons.size() + " - " + newLetters.size());
			return;
		}
		for (int i = 0; i < activeButtons.size(); i++) {
			activeButtons.get(i).setLetter(newLetters.get(i));
		}
	}
	
	public void clearScreen() {
		for (Button button : activeButtons) {
			button.setBackgroundColor(Color.LTGRAY);
			
		}
		clearArrays();
		s = "";
		text.setText(s);
		updateOKButton();
	}
	
	public void clearArrays() {
		activeButtons = new ArrayList<MatrixButton>();
		currentWord = new ArrayList<Letter>();
		
	}
}
