package tyborg.me.gymlog.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyler Berry on 8/13/2015.
 */
public class Session {
    private String title;
    private List<Workout> workouts;

    public Session(String title) {
        this.workouts = new ArrayList<>();
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }
}
