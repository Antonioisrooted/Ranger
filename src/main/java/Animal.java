import org.sql2o.Connection;

import java.util.List;

public abstract class Animal {


    public String name;
    public int id;
    public String type;
    public String age;
    public String health;

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public String getAge(){
        return age;
    }
    public String getHealth(){ return health; }



    public List<Sightings> getSightings() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animalid = :id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sightings.class);
        }
    }
}
