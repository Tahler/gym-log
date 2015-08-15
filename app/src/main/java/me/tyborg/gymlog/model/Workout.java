package me.tyborg.gymlog.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyler Berry on 8/13/2015.
 */
public class Workout {
    private String title;
    private List<Set> sets;

    public Workout(String title) {
        this.sets = new ArrayList<>();
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void addSet(Set set) {
        sets.add(set);
    }
}
