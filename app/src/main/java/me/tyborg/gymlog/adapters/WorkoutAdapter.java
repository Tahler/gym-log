package me.tyborg.gymlog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.tyborg.gymlog.R;
import me.tyborg.gymlog.model.Set;
import me.tyborg.gymlog.model.Workout;

/**
 * Created by Tyler Berry on 8/15/2015.
 */
public class WorkoutAdapter extends BaseAdapter {
    private List<Workout> workouts;

    public WorkoutAdapter(List<Workout> workouts) {
        this.workouts = workouts;
    }

    @Override
    public int getCount() {
        return workouts.size();
    }

    @Override
    public Object getItem(int position) {
        return workouts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_list_row, parent, false);
        } else {
            view = convertView;
        }

        ViewHolder holder = new ViewHolder(view);

        Workout workout = workouts.get(position);
        holder.workoutTitle.setText(workout.getTitle());

        holder.workoutSets.setAdapter(new SetAdapter(workout.getSets()));

        return view;
    }

    // The row in a workout list
    private static class ViewHolder {
        public TextView workoutTitle;
        public ListView workoutSets;

        public ViewHolder(View v) {
            workoutTitle = (TextView) v.findViewById(R.id.workout_title_text_view);
            workoutSets = (ListView) v.findViewById(R.id.workout_set_list_view);
        }
    }
}
