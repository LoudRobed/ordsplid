package view;

import java.util.ArrayList;

import model.Player;
import controller.GameController;
import controller.PlayerController;
import tdt4240.ordsplid.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ScoreDialog extends Dialog{
	
	private Button continueButton;
	private GameController gController = GameController.instance();
	private ArrayList<Player> players;
	private String[] playerString;
	private ListView listView = (ListView)findViewById(R.id.dialog_score_list);
	
	public ScoreDialog(Context context) {
		super(context);
		this.setContentView(R.layout.dialog_score_view);
		players = PlayerController.instance().getPlayersSortedByScore();
		
		continueButton = (Button)findViewById(R.id.continue_button);
		continueButton.setOnClickListener(new View.OnClickListener() {		
			
			public void onClick(View arg0) {
				gController.nextTurn();
				ScoreDialog.this.dismiss();
			}
		});
		
		for (int i = 0; i < players.size(); i++) {
			playerString[i] = players.get(i).toString();
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, 0, playerString);
		listView.setAdapter(adapter);
	}
}
