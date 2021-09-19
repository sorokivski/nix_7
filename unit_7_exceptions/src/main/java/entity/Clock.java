package entity;

import lombok.Data;

public
@Data
class Clock implements Comparable<Clock> {
    private static final int STARTING_HOUR = 00;
    private static final int STARTING_MINUTE = 00;
    private static final int STARTING_SECOND = 00;
    private static final int STARTING_MILLISECOND = 000;
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;

    public Clock() {
        this.hours = STARTING_HOUR;
        this.minutes = STARTING_MINUTE;
        this.seconds = STARTING_SECOND;
        this.milliseconds = STARTING_MILLISECOND;
    }

    public Clock(int hh, int mn) {
        this.hours = hh;
        this.minutes = mn;
        this.seconds = STARTING_SECOND;
        this.milliseconds = STARTING_MILLISECOND;
    }

    public Clock(int hh, int mn, int ss, int msc) {
        this.milliseconds = msc;
        this.minutes = mn;
        this.hours = hh;
        this.seconds = ss;
    }

    public Clock(int hh, int mn, int ss) {
        this.minutes = mn;
        this.hours = hh;
        this.seconds = ss;
        this.milliseconds = STARTING_MILLISECOND;
    }

    public String toStringAll() {
        return " " + hours + ":" + minutes + ":" + seconds + ":" + milliseconds;
    }

    @Override
    public int compareTo(Clock clock) {
        if (clock.getHours() == this.getHours()
                && clock.getMinutes() == this.getMinutes()
                && clock.getSeconds() == this.getSeconds()
                && clock.getMilliseconds() == this.getMilliseconds()) return 0;
        else {
            if (this.hours > clock.getHours()) return 1;
            else {
                if (this.hours == clock.getHours() && this.minutes > clock.getMinutes()) return 1;
                else {
                    if (this.hours == clock.getHours() && this.minutes == clock.getMinutes() && this.seconds > clock.getSeconds())
                        return 1;
                    else {
                        if (this.hours == clock.getHours() && this.minutes == clock.getMinutes() && this.seconds == clock.getSeconds() && this.milliseconds > clock.getMilliseconds())
                            return 1;
                        else return -1;
                    }
                }
            }
        }
    }
}
