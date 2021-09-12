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
public class convertDate {
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
                System.out.println(year + month + day);
            }
        } catch (IOException e) {
            System.out.println("error of opening file");
        }
    }
}
