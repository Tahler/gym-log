package me.tyborg.gymlog.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tyler Berry on 8/13/2015.
 */
public class Session {
    private String title;
    private Date date;
    private List<Workout> workouts;

    public Session(String title) {
        this.workouts = new ArrayList<>();
        this.date = new Date();
        setTitle(title);
    }

    public Session(String title, Date date) {
        this.workouts = new ArrayList<>();
        this.date = date;
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private static DateFormat df = new SimpleDateFormat("EEEE, MMMM dd");
    public String getFormattedDate() {
        return df.format(date);
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }
}
