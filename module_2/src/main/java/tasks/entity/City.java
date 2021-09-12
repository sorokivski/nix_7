package tasks.entity;

public class City {
    private final int id;
    private final String name;

    public City() {
        id = 0;
        name = "0";
    }

    public City(int i, String n) {
        id = i;
        name = n;
    }

    public String getCity() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean equals(String cityName) {
        return name.equals(cityName);
    }
}