package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

/*
Дан список дат (строковая запись) в форматах типа “2020/04/05”,
“05/04/2020”, “04-05-2020” (все даты в примере - 5е апреля 2020)
Вернуть список дат (строковая запись) в формате “20200405”.
Даты с неверным форматом - игнорировать.
 */
public class СonvertDate {
    private static final String INPUT_FILE = "resources/dates.txt";

    static String getResourceFileAsString(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(fileName)) {
            if (is == null) return null;
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }

    public static ArrayList<Integer> getLongMonth() {
        ArrayList<Integer> longMonth = new ArrayList<>();
        longMonth.add(1);
        longMonth.add(3);
        longMonth.add(5);
        longMonth.add(7);
        longMonth.add(8);
        longMonth.add(10);
        longMonth.add(12);
        return longMonth;
    }

    public static ArrayList<Integer> getRegularMonth() {
        ArrayList<Integer> longMonth = new ArrayList<>();

        longMonth.add(4);
        longMonth.add(6);
        longMonth.add(9);
        longMonth.add(11);

        return longMonth;
    }

    public void run() {
        String s;
        try {
            s = getResourceFileAsString(INPUT_FILE);
            assert s != null;
            for (String i : s.split("\r\n")) {
                ArrayList<String> strings = new ArrayList<>(3);

                for (String j : i.split("[/-]+")) {
                    strings.add(j);

                }
                String year, month, day;

                if (i.contains("-")) {
                    month = strings.get(0);
                    day = strings.get(1);
                    year = strings.get(2);

                } else if (i.contains("/")) {
                    if (strings.get(2).length() == 4) {
                        day = strings.get(0);
                        month = strings.get(1);
                        year = strings.get(2);
                    } else {
                        day = strings.get(2);
                        month = strings.get(1);
                        year = strings.get(0);
                    }
                } else {
                    year = " ";
                    month = " ";
                    day = " ";
                }
                if (checkDate(day, month, year))
                    System.out.println(year + month + day);
                else System.out.println("Inputted date is incorrect");
            }
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException FormatException) {
            System.out.println("error");
        }

    }

    private boolean checkDate(String day, String month, String year) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        if (y > 0 && m < 13 && d > 0 && d < 29) return true;
        else if (y > 0 && getLongMonth().contains(m) && d > 0 && d < 32) return true;
        else if (y > 0 && getRegularMonth().contains(m) && d > 0 && d < 31) return true;
        else return y > 0 && m == 2 && y % 4 == 0 && d > 0 && d < 30;
    }
}
