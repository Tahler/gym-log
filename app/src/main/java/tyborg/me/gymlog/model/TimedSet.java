package tyborg.me.gymlog.model;

/**
 * Created by Tyler Berry on 8/14/2015.
 */
public class TimedSet extends Set {
    private Long milliseconds;

    public TimedSet(Long milliseconds) {
        setMilliseconds(milliseconds);
    }

    public Long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Long milliseconds) {
        if (milliseconds > 0) this.milliseconds = milliseconds;
        // TODO: else throw exception?
    }
}
