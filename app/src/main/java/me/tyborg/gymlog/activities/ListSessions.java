package me.tyborg.gymlog.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.DateSorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import me.tyborg.gymlog.adapters.SessionAdapter;
import me.tyborg.gymlog.model.ReppedSet;
import me.tyborg.gymlog.model.Session;
import me.tyborg.gymlog.R;
import me.tyborg.gymlog.model.Set;
import me.tyborg.gymlog.model.TimedSet;
import me.tyborg.gymlog.model.WeightedSet;
import me.tyborg.gymlog.model.Workout;

public class ListSessions extends Activity {
    private List<Session> sessions;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sessions);

// BEGIN DUMMY DATA
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        Date twoDaysAgo = cal.getTime();
        cal.add(Calendar.DATE, -2);
        Date fourDaysAgo = cal.getTime();

    // BEGIN BACK
        Session back = new Session("Back and Legs");

        Workout latPulldown = new Workout("Lat Pulldown");
        latPulldown.addSet(new WeightedSet(15, 75.0f));
        latPulldown.addSet(new WeightedSet(15, 75.0f));
        latPulldown.addSet(new WeightedSet(15, 90.0f));
        latPulldown.addSet(new WeightedSet(15, 90.0f));
        back.addWorkout(latPulldown);

        Workout deadlift = new Workout("Deadlift");
        deadlift.addSet(new WeightedSet(10, 95.0f));
        deadlift.addSet(new WeightedSet(10, 95.0f));
        deadlift.addSet(new WeightedSet(10, 115.0f));
        deadlift.addSet(new WeightedSet(10, 115.0f));
        back.addWorkout(deadlift);

        Workout pullups = new Workout("Pull-Ups");
        pullups.addSet(new ReppedSet(6));
        pullups.addSet(new ReppedSet(5));
        pullups.addSet(new ReppedSet(4));
        back.addWorkout(pullups);

    // END BACK

    // BEGIN ARMS
        Session arms = new Session("Arms and Abs", twoDaysAgo);

        Workout barbellCurl = new Workout("Barbell Curl");
        barbellCurl.addSet(new WeightedSet(12, 45.0f));
        barbellCurl.addSet(new WeightedSet(12, 45.0f));
        barbellCurl.addSet(new WeightedSet(12, 45.0f));
        barbellCurl.addSet(new WeightedSet(12, 45.0f));
        arms.addWorkout(barbellCurl);

        Workout hammerCurl = new Workout("Dumbbell Hammer Curl");
        hammerCurl.addSet(new WeightedSet(12, 17.0f));
        hammerCurl.addSet(new WeightedSet(12, 15.0f));
        hammerCurl.addSet(new WeightedSet(12, 15.0f));
        hammerCurl.addSet(new WeightedSet(12, 15.0f));
        arms.addWorkout(hammerCurl);

        Workout plank = new Workout("Plank");
        plank.addSet(new TimedSet(60000L));
        plank.addSet(new TimedSet(60000L));
        plank.addSet(new TimedSet(60000L));
        arms.addWorkout(plank);
    // END ARMS

    // BEGIN CHEST
        Session chest = new Session("Chest and Shoulders", fourDaysAgo);

        Workout benchPress = new Workout("Bench Press");
        benchPress.addSet(new WeightedSet(12, 105.0f));
        benchPress.addSet(new WeightedSet(12, 105.0f));
        benchPress.addSet(new WeightedSet(12, 85.0f));
        benchPress.addSet(new WeightedSet(12, 85.0f));
        chest.addWorkout(benchPress);

        Workout dumbbellFly = new Workout("Dumbbell Fly");
        dumbbellFly.addSet(new WeightedSet(12, 25.0f));
        dumbbellFly.addSet(new WeightedSet(10, 20.0f));
        dumbbellFly.addSet(new WeightedSet(6, 20.0f));
        chest.addWorkout(dumbbellFly);

        Workout dumbbellBench = new Workout("Dumbbell Bench");
        dumbbellBench.addSet(new WeightedSet(12, 30.0f));
        dumbbellBench.addSet(new WeightedSet(12, 30.0f));
        dumbbellBench.addSet(new WeightedSet(12, 30.0f));
        chest.addWorkout(dumbbellBench);
    // END CHEST

        sessions = new ArrayList<>(Arrays.asList(
                chest,
                arms,
                back
        ));

        Collections.sort(sessions);
        Collections.reverse(sessions);
// END DUMMY DATA

        recyclerView = (RecyclerView) findViewById(R.id.sessions_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SessionAdapter(this, sessions));
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
        switch (item.getItemId()) {
            case R.id.action_add_session:
                break;
            case R.id.action_filter:
                break;
        }
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
