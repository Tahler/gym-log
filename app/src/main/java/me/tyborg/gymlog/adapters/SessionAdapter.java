package me.tyborg.gymlog.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import me.tyborg.gymlog.R;
import me.tyborg.gymlog.model.Session;
import me.tyborg.gymlog.model.Set;
import me.tyborg.gymlog.model.Workout;

/**
 * Created by Tyler Berry on 8/14/2015.
 */
public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {
    private LayoutInflater inflater;
    private List<Session> sessions;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class SessionViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView date;
        public LinearLayout workoutList;

        public SessionViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.session_title_text_view);
            date = (TextView) v.findViewById(R.id.session_date_text_view);
            workoutList = (LinearLayout) v.findViewById(R.id.session_workout_list);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SessionAdapter(Context context, List<Session> sessions) {
        this.inflater = LayoutInflater.from(context);
        this.sessions = sessions;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.session_card_view, parent, false);
        return new SessionViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        // for each set in that workout, make a row in the right list view
        Session session = sessions.get(position);

        holder.title.setText(session.getTitle());
        holder.date.setText(session.getFormattedDate());

        // for each workout in this session, add a workout_list_row view to workout_list
        for (Workout workout : session.getWorkouts()) {
            LinearLayout workoutList = holder.workoutList;

            View workoutListRow = inflater.inflate(R.layout.workout_list_row, null);
            WorkoutViewHolder workoutHolder = new WorkoutViewHolder(workoutListRow);
            workoutHolder.title.setText(workout.getTitle());
            workoutHolder.numberOfSets.setText(workout.getNumberOfSets() + " sets");
            // for each set in this workout, add a set_list_row view to set_list
            for (Set set : workout.getSets()) {
                LinearLayout setList = workoutHolder.setList;

                View setListRow = inflater.inflate(R.layout.set_list_row, null);
                SetViewHolder setHolder = new SetViewHolder(setListRow);
                setHolder.setEntry.setText(set.toString());

                setList.addView(setListRow);
            }

            workoutList.addView(workoutListRow);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return sessions.size();
    }

    private static class WorkoutViewHolder {
        public TextView title;
        public TextView numberOfSets;
        public LinearLayout setList;

        public WorkoutViewHolder(View v) {
            title = (TextView) v.findViewById(R.id.workout_title_text_view);
            numberOfSets = (TextView) v.findViewById(R.id.workout_number_of_sets_text_view);
            setList = (LinearLayout) v.findViewById(R.id.workout_set_list);
        }
    }

    private static class SetViewHolder {
        public TextView setEntry;

        public SetViewHolder(View v) {
            setEntry = (TextView) v.findViewById(R.id.set_text_view);
        }
    }
}
