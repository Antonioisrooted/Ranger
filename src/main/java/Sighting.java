import org.sql2o.Connection;

import java.util.List;

public class Sighting {
    private String animal;
    private String location;
    private String ranger_name;

    public Sighting(String animal, String location, String ranger_name) {
        this.animal = animal;
        this.location = location;
        this.ranger_name = ranger_name;
    }

    public String getAnimal() {
        return animal;
    }

    public String getLocation() {
        return location;
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public void add() {
    }
}