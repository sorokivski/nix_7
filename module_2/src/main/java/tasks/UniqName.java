package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Дан список имен. Найти первое уникальное имя. Допустимая
временная сложность - O(n) при условии, что доступ к элементу
списка по индексу - O(1).
 */
public class UniqName {

    private static final String INPUT_FILE = "resources/names.txt";

    public static String findUnique(ArrayList<String> names) {
        String unique = "null";
        for (int i = 0; i < names.size(); i++) {
            if (i == 0 && !names.get(1).equals(names.get(0))) {
                unique = names.get(0);
                break;
            } else if (i > 0 && i < names.size() - 1 && !names.get(i - 1).equals(names.get(i)) && !names.get(i + 1).equals(names.get(i))) {
                unique = names.get(i);
                break;
            } else if (i == names.size() - 1) {
                if (!names.get(i).equals(names.get(i - 1))) unique = names.get(i);
                else unique = "null";
            }
        }
        return unique;
    }

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

    public void findFirstUniq() {
        String s;
        try {
            s = getResourceFileAsString(INPUT_FILE);
            ArrayList<String> names = new ArrayList<>();
            assert s != null;
            for (String str : s.split("\r\n")) {
                if (checkName(str)) names.add(str);
            }
            Collections.sort(names);
            System.out.println(names);
            System.out.println("first-founded unique name: " + findUnique(names));
        } catch (IOException e) {
            System.out.println("error of opening file");
        }

    }

    public boolean checkName(String name) {
        return Pattern.matches("^[\\p{L} .'-]*$", name);
    }
}