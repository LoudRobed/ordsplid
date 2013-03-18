package view;

import java.util.ArrayList;

import model.Letter;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import controller.WordController;

public class ButtonAdapter extends BaseAdapter{
	private Context mContext;
	private WordController wController = WordController.instance();
	ArrayList<Letter> s = wController.retrieveNewLettersFromBag(16);
	private ArrayList<Button> buttonList = new ArrayList<Button>();
	
	
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
        return buttonList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public ArrayList<Letter> getInUseList(){
    	return s;
    }
    
      
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        MatrixButton btn;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            btn = new MatrixButton(mContext);
            //btn.setLayoutParams(new GridView.LayoutParams(85, 85));
            btn.setPadding(8, 8, 8, 8);
            btn.setOnClickListener(mOnButtonClick);
        } else {
            btn = (MatrixButton) convertView;
        }
        buttonList.add(btn);
        //Get a random letter from the scrabblebag and set it to the button
        btn.setId(position);
        btn.setLetter(s.get(position));
        btn.setBackgroundColor(Color.LTGRAY);
        return btn;
    }
}


//Added new class to store letter-object in buttons
class MatrixButton extends Button {
	private Letter letter;
	
	public MatrixButton(Context context) {
		super(context);
	}
	
	public void setLetter(Letter letter) {
		this.letter = letter;
		setText(letter.toString());
	}
	
	public Letter getLetter() {
		return letter;
	}
	
	
}
