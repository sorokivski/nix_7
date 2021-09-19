package entity;

import lombok.Data;

public
@Data
class CustomDateTime implements Comparable<CustomDateTime> {
    private Calendar calendar;
    private Clock clock;

    public CustomDateTime(Calendar c) {
        this.calendar = c;
        this.clock = new Clock();
    }

    public CustomDateTime() {
        this.calendar = new Calendar();
        this.clock = new Clock();
    }

    public CustomDateTime(Calendar c, Clock clock) {
        this.calendar = c;
        this.clock = clock;
    }

    public String toStringAll() {
        return " " + calendar.toStringAll() + " " + clock.toStringAll();
    }

    @Override
    public int compareTo(CustomDateTime o) {
        if (this.calendar.compareTo(o.getCalendar()) == 1) return 1;
        else {
            if (this.calendar.compareTo(o.getCalendar()) == 0) return clock.compareTo(o.getClock());
            else return -1;
        }
    }
}
