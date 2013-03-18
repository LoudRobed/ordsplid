package view;

import java.util.ArrayList;

import controller.WordController;
import model.Letter;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class ButtonAdapter extends BaseAdapter{
	private Context mContext;
	private WordController wController = new WordController();
	
    // Declare button click listener variable
    private OnClickListener mOnButtonClick;

    // Method to set button click listener variable
    public void setOnButtonClickListener(OnClickListener listener) {
        mOnButtonClick = listener;
    }
	
	public ButtonAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 16;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

      
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Button btn;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            btn = new Button(mContext);
            //btn.setLayoutParams(new GridView.LayoutParams(85, 85));
            btn.setPadding(8, 8, 8, 8);
            btn.setOnClickListener(mOnButtonClick);
        } else {
            btn = (Button) convertView;
        }
        
        //Get a random letter from the scrabblebag and set it to the button
        ArrayList<Letter> s = wController.retrieveNewLettersFromBag(1);
        
        btn.setText(s.get(0).toString().substring(0, 1));
        return btn;
    }
}
