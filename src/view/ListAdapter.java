package view;

import java.util.ArrayList;

import model.Player;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import controller.PlayerController;

/**
 * Adapterclass for a List used in the GameOverView.
 *
 */
public class ListAdapter extends BaseExpandableListAdapter {
	Context mContext;
	public ListAdapter(Context context){
		this.mContext = context;
	}
	
    private ArrayList<Player> players = PlayerController.instance().getPlayersSortedByScore();
    
    public Object getChild(int groupPosition, int childPosition) {
        return players.get(groupPosition).getWords().getStatistics().get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
    	return players.get(groupPosition).getWords().getStatistics().size();
    }

    public TextView getGenericView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);

        TextView textView = new TextView(mContext);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(100, 0, 0, 0);
        textView.setTextSize(15);
        return textView;
    }
    
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = getGenericView();
        textView.setText((String) getChild(groupPosition, childPosition));
        return textView;
    }

    public Object getGroup(int groupPosition) {
        return players.get(groupPosition);
    }

    public int getGroupCount() {
        return players.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView = getGenericView();
        textView.setTextSize(20);
        textView.setText(((Player) getGroup(groupPosition)).getPlayerInfo());
        return textView;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public boolean hasStableIds() {
        return true;
    }

}
