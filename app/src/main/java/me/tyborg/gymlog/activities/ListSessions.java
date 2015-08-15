package me.tyborg.gymlog.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import me.tyborg.gymlog.adapters.SessionAdapter;
import me.tyborg.gymlog.model.Session;
import me.tyborg.gymlog.R;
import me.tyborg.gymlog.model.WeightedSet;
import me.tyborg.gymlog.model.Workout;

public class ListSessions extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Session> sessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sessions);

        // BEGIN DUMMY DATA
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        Date twoDaysAgo = cal.getTime();

        Session chest = new Session("Chest and Shoulders");
        Session back = new Session("Back", twoDaysAgo);

        Workout bench = new Workout("Bench Press");
        bench.addSet(new WeightedSet(12, 105.0f));
        bench.addSet(new WeightedSet(12, 105.0f));
        bench.addSet(new WeightedSet(12, 85.0f));
        bench.addSet(new WeightedSet(12, 85.0f));
        chest.addWorkout(bench);

        Workout dumbbellFly = new Workout("Dumbbell Fly");
        dumbbellFly.addSet(new WeightedSet(12, 20.0f));
        dumbbellFly.addSet(new WeightedSet(12, 20.0f));
        dumbbellFly.addSet(new WeightedSet(12, 20.0f));
        dumbbellFly.addSet(new WeightedSet(12, 20.0f));
        chest.addWorkout(dumbbellFly);

        sessions = new ArrayList<>(Arrays.asList(
                chest,
                back
        ));
        // END DUMMY DATA

        recyclerView = (RecyclerView) findViewById(R.id.sessions_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new SessionAdapter(sessions));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_sessions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
