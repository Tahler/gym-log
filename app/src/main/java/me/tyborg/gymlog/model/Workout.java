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
        if (!title.isEmpty()) this.title = title;
        else throw new IllegalArgumentException("Title cannot be empty");
    }

    public List<Set> getSets() {
        return sets;
    }

    public void addSet(Set set) {
        sets.add(set);
    }

    public Integer getNumberOfSets() {
        return sets.size();
    }
}
