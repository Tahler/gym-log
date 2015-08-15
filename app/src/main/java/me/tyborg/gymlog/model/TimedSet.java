package me.tyborg.gymlog.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private static DateFormat df = new SimpleDateFormat("m:ss");
    @Override
    public String toString() {
        return df.format(new Date(milliseconds));
    }
}
