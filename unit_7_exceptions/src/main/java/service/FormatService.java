package service;

import entity.Calendar;
import entity.Clock;
import entity.CustomDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class FormatService {
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private CustomDateTime customDateTime;

    public CustomDateTime createDateTime(String date, String format) {
        customDateTime = new CustomDateTime();
        if (checkFormat(date, format)) {
            return customDateTime;
        }
        LOGGER_ERROR.error("failed to create date and time");
        return null;
    }

    public boolean checkFormat(String date, String format) {
        switch (format) {
            case "ddmmyyyy":
                if (ddmmyyyy(date)) return true;
                break;
            case "mmddyyyy":
                if (mmddyyyy(date)) return true;
                break;
            case "yearhhmn":
                if (yearhhmn(date)) return true;
                break;
            case "ddmmyyyyhhmnssmsc":
                if (ddmmyyyyhhmnssmsc(date)) return true;
                break;
            case "ddmmyyyyhhmnss":
                if (ddmmyyyyhhmnss(date)) return true;
                break;
            case "ddmmyyyyhhmn":
                if (ddmmyyyyhhmn(date)) return true;
                break;
            case "monthdyy":
                if (monthdyy(date)) return true;
                break;
            case "ddmonthyyyyhhmn":
                if (ddmonthyyyyhhmn(date)) return true;
                break;
            default:
                break;
        }
        LOGGER_ERROR.error("Incorrect format");
        return false;
    }

    private boolean ddmonthyyyyhhmn(String date) {
        ArrayList<String> strings = new ArrayList<>(3);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int month = Calendar.getMonthByName(strings.get(1));
            int day = Integer.parseInt(strings.get(0));
            int year = Integer.parseInt(strings.get(2));
            int hours = Integer.parseInt(strings.get(3));
            int minutes = Integer.parseInt(strings.get(4));
            customDateTime.setCalendar(new Calendar(day, month, year));
            customDateTime.setClock(new Clock(hours, minutes));
        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;
    }

    public boolean ddmmyyyy(String date) {

        ArrayList<String> strings = new ArrayList<>(3);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int month = Integer.parseInt(strings.get(1));
            int day = Integer.parseInt(strings.get(0));
            int year = Integer.parseInt(strings.get(2));
            customDateTime.setCalendar(new Calendar(day, month, year));
            customDateTime.setClock(new Clock());
        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;
    }

    public boolean mmddyyyy(String date) {

        ArrayList<String> strings = new ArrayList<>(3);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int month = Integer.parseInt(strings.get(0));
            int day = Integer.parseInt(strings.get(1));
            int year = Integer.parseInt(strings.get(2));
            customDateTime.setCalendar(new Calendar(day, month, year));
            customDateTime.setClock(new Clock());
        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;
    }

    public boolean yearhhmn(String date) {

        ArrayList<String> strings = new ArrayList<>(3);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int hh = Integer.parseInt(strings.get(1));
            int mn = Integer.parseInt(strings.get(2));
            int year = Integer.parseInt(strings.get(0));
            customDateTime.setCalendar(new Calendar(year));
            customDateTime.setClock(new Clock(hh, mn));
        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;

    }

    public boolean ddmmyyyyhhmnssmsc(String date) {

        ArrayList<String> strings = new ArrayList<>(7);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int month = Integer.parseInt(strings.get(1));
            int day = Integer.parseInt(strings.get(0));
            int hh = Integer.parseInt(strings.get(3));
            int mn = Integer.parseInt(strings.get(4));
            int year = Integer.parseInt(strings.get(2));
            int ss = Integer.parseInt(strings.get(5));
            int msc = Integer.parseInt(strings.get(6));
            customDateTime.setCalendar(new Calendar(day, month, year));
            customDateTime.setClock(new Clock(hh, mn, ss, msc));
        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;

    }

    public boolean ddmmyyyyhhmnss(String date) {

        ArrayList<String> strings = new ArrayList<>(7);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int day = Integer.parseInt(strings.get(0));
            int month = Integer.parseInt(strings.get(1));
            int hh = Integer.parseInt(strings.get(3));
            int mn = Integer.parseInt(strings.get(4));
            int year = Integer.parseInt(strings.get(2));
            int ss = Integer.parseInt(strings.get(5));

            customDateTime.setCalendar(new Calendar(day, month, year));
            customDateTime.setClock(new Clock(hh, mn, ss));
        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;
    }

    public boolean ddmmyyyyhhmn(String date) {

        ArrayList<String> strings = new ArrayList<>(7);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int day = Integer.parseInt(strings.get(0));
            int month = Integer.parseInt(strings.get(1));
            int year = Integer.parseInt(strings.get(2));
            int hh = Integer.parseInt(strings.get(3));
            int mn = Integer.parseInt(strings.get(4));

            customDateTime.setCalendar(new Calendar(day, month, year));
            customDateTime.setClock(new Clock(hh, mn));

        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;
    }

    public boolean monthdyy(String date) {

        ArrayList<String> strings = new ArrayList<>(7);
        for (String j : date.split("[./ :-]+")) {
            strings.add(j);
        }
        try {
            int month = Calendar.getMonthByName(strings.get(0));
            int day = Integer.parseInt(strings.get(1));
            int year = Integer.parseInt(strings.get(2));

            customDateTime.setCalendar(new Calendar(day, month, year));
            customDateTime.setClock(new Clock());

        } catch (NumberFormatException | IndexOutOfBoundsException FormatException) {
            return false;
        }
        return true;
    }
}
