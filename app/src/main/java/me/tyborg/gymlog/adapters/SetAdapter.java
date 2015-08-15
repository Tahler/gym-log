package me.tyborg.gymlog.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import me.tyborg.gymlog.R;
import me.tyborg.gymlog.model.Set;

/**
 * Created by Tyler Berry on 8/15/2015.
 */
public class SetAdapter extends BaseAdapter {
    private List<Set> sets;

    public SetAdapter(List<Set> sets) {
        this.sets = sets;
    }

    @Override
    public int getCount() {
        return sets.size();
    }

    @Override
    public Object getItem(int position) {
        return sets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_list_row, parent, false);
        } else {
            view = convertView;
        }

        ViewHolder holder = new ViewHolder(view);

        Set set = sets.get(position);
        holder.set.setText(set.toString());

        return view;
    }

    private static class ViewHolder {
        public TextView set;

        public ViewHolder(View v) {
            set = (TextView) v.findViewById(R.id.set_text_view);
        }
    }
}
