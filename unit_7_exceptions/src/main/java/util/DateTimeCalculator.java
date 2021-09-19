package util;

import entity.Calendar;
import entity.Clock;
import entity.CustomDateTime;
import service.DateTimeService;

public class DateTimeCalculator {

    private static final int LONG_YEAR = 366;
    private static final int YEAR = 365;
    private static final int MONTH = 30;
    private static final int LONG_MONTH = 31;
    private static final int SHORT_MONTH = 29;
    private static final int TINY_MONTH = 28;
    private static final int FEBRUARY = 2;
    private static final int HOURS_IN_DAY = 24;
    private static final int MIN_IN_HOUR = 60;
    private static final int SEC_IN_MIN = 60;
    private static final int MILLIS_IN_SEC = 1000;

    private static final DateTimeConverter CONVERTER = new DateTimeConverter();
    private static final DateTimeService SERVICE = new DateTimeService();


    public int calculateDifference(CustomDateTime d1, CustomDateTime d2) {

        int daysInCurrentYear = (d1.getCalendar().getDay() - 1) + CONVERTER.monthToDays(d1.getCalendar().getYear(), d1.getCalendar().getMonth());

        int yearDays = 0;
        for (int i = d2.getCalendar().getYear() + 1; i < d1.getCalendar().getYear(); i++) {
            if (i % 4 == 0) yearDays += LONG_YEAR;
            else yearDays += YEAR;
        }

        return Math.abs(daysInCurrentYear + yearDays + getdaysToEndOfYear(d2));
    }

    public CustomDateTime subtractDays(CustomDateTime date, int days) {
        if (days > YEAR) {
            return subtractDays(new CustomDateTime(new Calendar(date
                    .getCalendar().getDay(), date.getCalendar().getMonth(), date.getCalendar().getYear() - days / YEAR), date.getClock()), days % YEAR);
        } else {
            if (days > getdaysFromStartOfYear(date)) {
                return subtractDays(new CustomDateTime(new Calendar(date
                        .getCalendar().getDay(), 12, date.getCalendar().getYear() - 1), date.getClock()), days - getdaysFromStartOfYear(date));
            } else {
                if (days > date.getCalendar().getDay()) {
                    return subtractDays(new CustomDateTime(new Calendar(date
                            .getCalendar().getDay(), date.getCalendar().getMonth() - 1, date.getCalendar().getYear()), date.getClock()), days - date.getCalendar().getDay());
                } else {
                    return SERVICE.createDateTime(new CustomDateTime(new Calendar(date
                            .getCalendar().getDay() - days, date.getCalendar().getMonth(), date.getCalendar().getYear()), date.getClock()));

                }
            }
        }
    }

    public CustomDateTime subtractHours(CustomDateTime date, int h) {
        if (h > HOURS_IN_DAY) {
            return subtractHours(subtractDays(date, h / HOURS_IN_DAY), h % HOURS_IN_DAY);
        } else {
            if (h > date.getClock().getHours()) {
                return subtractHours(subtractDays(date, 1), h - HOURS_IN_DAY);
            } else return SERVICE
                    .createDateTime(new CustomDateTime(date.getCalendar(),
                            new Clock(date.getClock().getHours() - h, date.getClock().getMinutes(), date.getClock().getSeconds(),
                                    date.getClock().getMilliseconds())));
        }
    }

    public CustomDateTime subtractMinutes(CustomDateTime date, int min) {
        if (min > MIN_IN_HOUR) {
            return subtractMinutes(subtractHours(date, min / MIN_IN_HOUR), min % MIN_IN_HOUR);
        } else {
            if (min > date.getClock().getMinutes()) {
                return subtractMinutes(subtractHours(date, 1), min - MIN_IN_HOUR);
            } else return SERVICE
                    .createDateTime(new CustomDateTime(date.getCalendar(),
                            new Clock(date.getClock().getHours(), date.getClock().getMinutes() - min, date.getClock().getSeconds(),
                                    date.getClock().getMilliseconds())));
        }
    }

    public CustomDateTime subtractSeconds(CustomDateTime date, int s) {
        if (s > SEC_IN_MIN) {
            return subtractSeconds(subtractMinutes(date, s / SEC_IN_MIN), s % SEC_IN_MIN);
        } else {
            if (s > date.getClock().getSeconds()) {
                return subtractSeconds(subtractMinutes(date, 1), s - SEC_IN_MIN);
            } else return SERVICE
                    .createDateTime(new CustomDateTime(date.getCalendar(),
                            new Clock(date.getClock().getHours(), date.getClock().getMinutes(), date.getClock().getSeconds() - s,
                                    date.getClock().getMilliseconds())));
        }
    }

    public CustomDateTime subtractMillis(CustomDateTime date, int ms) {
        if (ms > MILLIS_IN_SEC) {
            return subtractMillis(subtractSeconds(date, ms / MILLIS_IN_SEC), ms % MILLIS_IN_SEC);
        } else {
            if (ms > date.getClock().getMilliseconds()) {
                return subtractMillis(subtractSeconds(date, 1), ms - MILLIS_IN_SEC);
            } else return SERVICE
                    .createDateTime(new CustomDateTime(date.getCalendar(),
                            new Clock(date.getClock().getHours(), date.getClock().getMinutes(), date.getClock().getSeconds(),
                                    date.getClock().getMilliseconds() - ms)));
        }
    }

    private int getdaysFromStartOfYear(CustomDateTime date) {
        return CONVERTER.monthToDays(date.getCalendar().getYear(), date.getCalendar().getMonth());
    }

    public CustomDateTime addDays(CustomDateTime date, int days) {
        if (days > YEAR) {
            return addDays(new CustomDateTime(new Calendar(date
                    .getCalendar().getDay(), date.getCalendar().getMonth(), date.getCalendar().getYear() + days / YEAR), date.getClock()), days % YEAR);
        } else {
            if (days > getdaysToEndOfYear(date)) {
                return addDays(new CustomDateTime(new Calendar(date
                        .getCalendar().getDay(), date.getCalendar().getMonth(), date.getCalendar().getYear() + days / YEAR), date.getClock()), days - getdaysToEndOfYear(date));
            } else {
                if (days > getDaysToEndOfMonth(date)) {
                    return addDays(new CustomDateTime(new Calendar(date
                            .getCalendar().getDay(), date.getCalendar().getMonth() + 1, date.getCalendar().getYear()), date.getClock()), days - getDaysToEndOfMonth(date));
                } else {
                    return SERVICE.createDateTime(new CustomDateTime(new Calendar(date
                            .getCalendar().getDay() + days, date.getCalendar().getMonth(), date.getCalendar().getYear()), date.getClock()));

                }
            }
        }
    }


    public CustomDateTime addHours(CustomDateTime d, int h) {
        if (h > HOURS_IN_DAY) {
            return addHours(addDays(d, h / HOURS_IN_DAY), h % HOURS_IN_DAY);
        } else if (h > hoursToEndOfDay(d)) {
            return addHours(addDays(d, 1), h - hoursToEndOfDay(d));
        } else
            return SERVICE
                    .createDateTime(new CustomDateTime(d.getCalendar(),
                            new Clock(d.getClock().getHours() + h, d.getClock().getMinutes(), d.getClock().getSeconds(),
                                    d.getClock().getMilliseconds())));

    }

    public CustomDateTime addMinutes(CustomDateTime d, int min) {
        if (min > MIN_IN_HOUR) {
            return addMinutes(addHours(d, min / MIN_IN_HOUR), min % MIN_IN_HOUR);
        } else if (min > minutesToEndOfHour(d)) {
            return addMinutes(addHours(d, 1), min - minutesToEndOfHour(d));
        } else
            return SERVICE
                    .createDateTime(new CustomDateTime(d.getCalendar(),
                            new Clock(d.getClock().getHours(), d.getClock().getMinutes() + min, d.getClock().getSeconds(),
                                    d.getClock().getMilliseconds())));
    }

    public CustomDateTime addSeconds(CustomDateTime d, int s) {
        if (s > SEC_IN_MIN) {
            return addSeconds(addMinutes(d, s / SEC_IN_MIN), s % SEC_IN_MIN);
        } else if (s > secondsToEndOfMin(d)) {
            return addSeconds(addMinutes(d, 1), s - secondsToEndOfMin(d));
        } else
            return SERVICE
                    .createDateTime(new CustomDateTime(d.getCalendar(),
                            new Clock(d.getClock().getHours(), d.getClock().getMinutes(), d.getClock().getSeconds() + s,
                                    d.getClock().getMilliseconds())));
    }

    public CustomDateTime addMillis(CustomDateTime d, int ms) {
        if (ms > MILLIS_IN_SEC) {
            return addMillis(addSeconds(d, ms / MILLIS_IN_SEC), ms % MILLIS_IN_SEC);
        } else if (ms > millisToEndOfSec(d)) {
            return addMillis(addSeconds(d, 1), ms - millisToEndOfSec(d));
        } else
            return SERVICE
                    .createDateTime(new CustomDateTime(d.getCalendar(),
                            new Clock(d.getClock().getHours(), d.getClock().getMinutes(), d.getClock().getSeconds(),
                                    d.getClock().getMilliseconds() + ms)));
    }

    private int millisToEndOfSec(CustomDateTime d) {
        return MILLIS_IN_SEC - d.getClock().getMilliseconds();
    }

    private int secondsToEndOfMin(CustomDateTime d) {
        return SEC_IN_MIN - d.getClock().getSeconds();
    }


    private int minutesToEndOfHour(CustomDateTime d) {
        return MIN_IN_HOUR - d.getClock().getMinutes();
    }

    private int getDaysToEndOfMonth(CustomDateTime date) {
        int daysInMonth = 0;
        if (Calendar.getLongMonth().contains(date.getCalendar().getMonth())) {
            daysInMonth += (LONG_MONTH - date.getCalendar().getDay());
        } else {
            if (date.getCalendar().getMonth() == FEBRUARY && date.getCalendar().getYear() % 4 == 0) {
                daysInMonth += (SHORT_MONTH - date.getCalendar().getDay());
            } else if (date.getCalendar().getMonth() == FEBRUARY && date.getCalendar().getYear() % 4 != 0) {
                daysInMonth += (TINY_MONTH - date.getCalendar().getDay());
            } else daysInMonth += (MONTH - date.getCalendar().getDay());
        }
        return daysInMonth;
    }

    private int getdaysToEndOfYear(CustomDateTime date) {

        int monthInYear = 0;
        for (int i = date.getCalendar().getMonth() + 1; i <= 12; i++) {
            if (Calendar.getLongMonth().contains(i)) monthInYear += LONG_MONTH;
            else {
                if (i == FEBRUARY)
                    monthInYear += TINY_MONTH; // if there are 29 day it was already added in cycle for years
                else monthInYear += MONTH;
            }
        }

        return monthInYear + getDaysToEndOfMonth(date);
    }

    private int hoursToEndOfDay(CustomDateTime d) {
        return HOURS_IN_DAY - d.getClock().getHours();
    }
}
