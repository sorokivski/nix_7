package tasks;

import tasks.entity.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CommisVoyageur {
    private static final String INPUT_FILE = "resources/input.txt";
    private static final String OUTPUT_FILE = "output.txt";
    static City[] cities;

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

    public void lessCost() {
        String content;
        try {
            content = getResourceFileAsString(INPUT_FILE);

            Queue<String> strings = new ArrayDeque<>();
            assert content != null;
            for (String s : content.split("\r\n")) {
                strings.add(s);
            }

            List<String> output = new ArrayList<>();
            Path file = Paths.get(OUTPUT_FILE);

            int numOfCities = Integer.parseInt(strings.poll().trim());
            cities = new City[numOfCities];

            int[][] matrixOfCosts = new int[numOfCities][numOfCities];
            for (int i = 0; i < numOfCities; i++) {
                for (int j = 0; j < numOfCities; j++) {
                    if (i == j) matrixOfCosts[i][j] = 0;
                    else
                        matrixOfCosts[i][j] = 999999999;
                }
            }

            int id = 1, temp, minindex, min;
            int num = numOfCities;

            while (num != 0) {

                String name = strings.poll();
                cities[id - 1] = new City(id, name);

                int numOfRelations = Integer.parseInt(strings.poll().trim());
                while (numOfRelations != 0) { // for all relations
                    List<String> arr = new ArrayList<>(2);
                    for (String a : strings.poll().split(" ")) {
                        arr.add(a);
                    }
                    int id1 = Integer.parseInt(arr.get(0).trim());
                    int cost = Integer.parseInt(arr.get(1).trim());
                    matrixOfCosts[id - 1][id1 - 1] = cost;
                    numOfRelations--;
                }
                num--;
                id++;
            }

            int numOfPathesToFind = Integer.parseInt(strings.poll().trim());
            while (numOfPathesToFind != 0) {

                List<String> arr = new ArrayList<>(2);
                for (String a : strings.poll().split(" ")) {
                    arr.add(a);
                }
                int begin_index = 0, second = 0;

                for (int i = 0; i < numOfCities; i++) {

                    if (cities[i].getCity().equals(arr.get(0))) {

                        begin_index = i;
                    } else if (cities[i].getCity().equals(arr.get(1))) {
                        second = i;

                    } else continue;
                }

                int[] d = new int[numOfCities];
                int[] v = new int[numOfCities];

                for (int i = 0; i < numOfCities; i++) {
                    d[i] = 999999999;
                    v[i] = 1;
                }
                d[begin_index] = 0;
                do {
                    minindex = 999999999;
                    min = 999999999;
                    for (int i = 0; i < numOfCities; i++) {
                        if ((v[i] == 1) && (d[i] < min)) {
                            min = d[i];
                            minindex = i;
                        }
                    }

                    if (minindex != 999999999) {
                        for (int i = 0; i < numOfCities; i++) {
                            if (matrixOfCosts[minindex][i] > 0) {
                                temp = min + matrixOfCosts[minindex][i];
                                if (temp < d[i]) d[i] = temp;
                            }
                        }
                        v[minindex] = 0;
                    }
                } while (minindex < 999999999);
                System.out.println(" Cheaper cost is: " + d[second]);
                output.add(" " + d[second]);
                numOfPathesToFind--;
            }
            Files.write(file, output, StandardCharsets.UTF_8);

        } catch (IOException e) {
            System.out.println("some error of opening file");
        }

    }

}
