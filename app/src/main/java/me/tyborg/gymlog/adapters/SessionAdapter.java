package me.tyborg.gymlog.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import me.tyborg.gymlog.R;
import me.tyborg.gymlog.model.Session;

/**
 * Created by Tyler Berry on 8/14/2015.
 */
public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.ViewHolder> {
    private List<Session> sessions;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView session_title;
        public TextView session_date;

        public ViewHolder(View v) {
            super(v);
            session_title = (TextView) v.findViewById(R.id.session_title_text_view);
            session_date = (TextView) v.findViewById(R.id.session_date_text_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SessionAdapter(List<Session> sessions) {
        this.sessions = sessions;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.session_card_view, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.session_title.setText(sessions.get(position).getTitle());
        holder.session_date.setText(sessions.get(position).getFormattedDate());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return sessions.size();
    }
}
