package view;

import tdt4240.ordsplid.R;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.TextView;

/**
 * Class for creating a view with a List of all the players, their score and written words when the game is completed.
 *
 */
public class GameOverView extends ExpandableListActivity {

    ListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
	    setContentView(R.layout.activity_game_over);

	    Button backButton = (Button) findViewById(R.id.game_over_button);
	    
	    backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
	    });

        // Set up our adapter
        mAdapter = new ListAdapter(GameOverView.this);
        setListAdapter(mAdapter);
        registerForContextMenu(getExpandableListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return false;
    }

}
