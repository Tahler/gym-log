package me.tyborg.gymlog.model;

/**
 * Created by Tyler Berry on 8/13/2015.
 * Body Weight (e.g. Pull ups, Sit ups, Dips)
 */
public class ReppedSet extends Set {
    private Integer reps;

    public ReppedSet(Integer reps) {
        setReps(reps);
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        if (reps > 0) this.reps = reps;
        else throw new IllegalArgumentException("Reps must be greater than 0");
    }

    @Override
    public String toString() {
        return getReps() + "";
    }
}
