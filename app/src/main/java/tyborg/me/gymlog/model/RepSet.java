package tyborg.me.gymlog.model;

/**
 * Created by Tyler Berry on 8/13/2015.
 * Body Weight
 */
public class RepSet extends Set {
    private Integer reps;

    public RepSet(Integer reps) {
        setReps(reps);
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        if (reps > 0) this.reps = reps;
        // TODO: else throw exception?
    }
}
