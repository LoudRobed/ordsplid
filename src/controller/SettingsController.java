package controller;

import model.Settings;
import tdt4240.ordsplid.R;
import view.MainActivity;
import view.SettingsView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SettingsController {
	static Settings settings = Settings.instance();
	
	public SettingsController() {
			
	}
	
	static public class ClickListener implements OnClickListener {
		public void onClick(View v) {
			
			try {
				int numberOfPlayers = Integer.parseInt(SettingsView.getNumberOfPlayers());
				int turnTime = Integer.parseInt(SettingsView.getTurnTime());
				settings.setNumberOfPlayers(numberOfPlayers);
				settings.setTurnTime(turnTime);
				SettingsView.instance().startActivity(MainActivity.class);
			}
			catch (NumberFormatException e) {
				SettingsDialog dialog = new SettingsDialog();
				dialog.start();
				e.printStackTrace();
			}
			
			
			
		}
	}
}

class SettingsDialog extends DialogFragment {
    public void start() {
    	show(getFragmentManager(), "missiles");
    }
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Nope")
               .setPositiveButton("Button things", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // FIRE ZE MISSILES!
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}