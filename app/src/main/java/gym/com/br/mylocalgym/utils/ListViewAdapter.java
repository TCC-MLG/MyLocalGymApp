package gym.com.br.mylocalgym.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import gym.com.br.mylocalgym.R;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<AcademiaNames> academiaNamesList = null;
    private ArrayList<AcademiaNames> arraylist;

    public ListViewAdapter(Context context, List<AcademiaNames> animalNamesList) {
        mContext = context;
        this.academiaNamesList = animalNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<AcademiaNames>();
        this.arraylist.addAll(animalNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return academiaNamesList.size();
    }

    @Override
    public AcademiaNames getItem(int position) {
        return academiaNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(academiaNamesList.get(position).getAcademiaName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        academiaNamesList.clear();
        if (charText.length() == 0) {
            academiaNamesList.addAll(arraylist);
        } else {
            for (AcademiaNames wp : arraylist) {
                if (wp.getAcademiaName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    academiaNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
