import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class SightingsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void sighting_instanceOfSightings_true(){
        Sightings testSighting = createSightings();
        assertEquals(true, testSighting instanceof Sightings);
    }
    @Test
    public void getAnimalId_getTheAnimalId_int(){
        Sightings testSighting = createSightings();
        assertEquals(1,testSighting.getAnimalId());
    }
    @Test
    public void getLocation_getSightingLocation_location()
    {   Sightings testSighting = createSightings();
        assertEquals("Zone A",testSighting.getSightLocation());
    }
    @Test
    public void getRanger_getTheRangerName_ranger(){
        Sightings testSighting = createSightings();
        assertEquals("John",testSighting.getRangerName());
    }
    @Test
    public void equal_checkWhetherSightingsContentAreTheSame_true(){
        Sightings testSighting = createSightings();
        assertTrue(testSighting.equals(testSighting));
    }
    @Test
    public void save_returnsTrueIfTheSavedAreEqual(){
        Sightings testSighting = createSightings();
        testSighting.save();
        assertTrue(Sightings.all().get(0).equals(testSighting));
    }
    @Test
    public void save_assignsIdToSpecificInstance(){
        Sightings testSighting = createSightings();
        testSighting.save();
        Sightings savedSightings = Sightings.all().get(0);
        assertEquals(savedSightings.getId(),testSighting.getId());
    }
    @Test
    public void all_returnsAllInstancesOfSightings_true(){
        Sightings testSighting = createSightings();
        testSighting.save();
        Sightings testSighting1 =new Sightings(1,"Zone A","Lenny");
        testSighting1.save();
        assertEquals(true,Sightings.all().get(0).equals(testSighting));
        assertEquals(true,Sightings.all().get(1).equals(testSighting1));

    }
    @Test
    public void find_returnSpecificSighting_testSighting1(){
        Sightings testSighting = createSightings();
        testSighting.save();
        Sightings testSighting1 =new Sightings(1,"Zone A","Lenny");
        testSighting1.save();
        assertEquals(Sightings.find(testSighting1.getId()),testSighting1);
    }
    @Test
    public void save_saveSAnimalIDIntoDb_true(){
        NormalAnimal testNormalAnimal = createNormalAnimal();
        testNormalAnimal.save();
        Sightings testSighting1 =new Sightings(testNormalAnimal.getId(),"Zone A","Lenny");
        testSighting1.save();
        Sightings savedSighting = Sightings.find(testSighting1.getId());
        assertEquals(savedSighting.getAnimalId(), testNormalAnimal.getId());
    }
//    @Test
//    public void save_recordsWhenTheSightingWasViewed(){
//        Sightings testSighting = createSightings();
//        testSighting.save();
//        Timestamp sightingViewed = Sightings.find(testSighting.getId()).getViewed();
//        Timestamp rightNow = new Timestamp(new Date().getTime());
//        assertEquals(rightNow.getDay(),sightingViewed.getDay());
//    }
    public NormalAnimal createNormalAnimal()
    {
        return new NormalAnimal("Lion", "Normal", "Healthy");
    }
    public Sightings createSightings()
    {
        return new Sightings(1, "Zone A", "John");
    }
}