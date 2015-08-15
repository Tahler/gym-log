package me.tyborg.gymlog.model;

/**
 * Created by Tyler Berry on 8/13/2015.
 */
public abstract class Set {
    /**
     * Forces children to override. This string appears in the embedded list of sets under the list of workouts.
     * @return A string representation of the set
     */
    public abstract String toString();
}
