import org.junit.rules.ExternalResource;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before(){
//        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "Access");
        DB.sql2o = new Sql2o("jdbc:postgresql://ec2-34-195-169-25.compute-1.amazonaws.com:5432/d94695gnva3af9", "oksagxtbqxyuho", "89bfede11005a36f20d82320dc75f3fa225f37d99fd98a787538f189759d57fcm");

    }

    @Override
    protected void after(){
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
}
