import org.sql2o.Connection;

import java.util.List;

public class Animal {
    private int animal_id;
    private String animal_name;
    private int animal_age;

    public Animal(int animal_id,String animal_name, int animal_age) {
        this.animal_id = animal_id;
        this.animal_name = animal_name;
        this.animal_age = animal_age;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public int getAnimal_age() {
        return animal_age;
    }

}
