import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void EndangeredAnimal_instanceOfEndangeredAnimal_true(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }
    @Test
    public void getName_returnNameOfEndangeredAnimal_cat(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        assertEquals("Lion", testEndangeredAnimal.getName());
    }
    @Test
    public void getHealth_returnHealthLevelOfTheAnimal_okay(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        assertEquals("Ill", testEndangeredAnimal.getHealth());
    }
    @Test
    public void getAge_returnAgeLevelOfTheAnimal_okay(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        assertEquals("New born", testEndangeredAnimal.getAge());
    }
    @Test
    public void equals_returnsTrueIfNamesAreTheSame_true(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        assertTrue(testEndangeredAnimal.equals(testEndangeredAnimal));
    }
    @Test
    public void save_savesEndangeredAnimalInstanceToDB_EndangeredAnimal(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }
    @Test
    public void id_assignIdToSpecificInstance(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true(){
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        testEndangeredAnimal.save();
        EndangeredAnimal testSecondAnimal = createEndangeredAnimal();
        testSecondAnimal.save();

        assertEquals(true, testEndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
        assertEquals(true, testSecondAnimal.all().get(1).equals(testSecondAnimal));
    }
    @Test
    public void all_returnsAnimalById() throws Exception{
        EndangeredAnimal testEndangeredAnimal = createEndangeredAnimal();
        testEndangeredAnimal.save();
        EndangeredAnimal testSecondAnimal = createEndangeredAnimal();
        testSecondAnimal.save();

        assertEquals(true, testSecondAnimal.find(testSecondAnimal.getId()).equals(testSecondAnimal));
    }

//    @Test
//    public void getSightings_retrievesAllSightingsFromDB_sightingList(){
//        EndangeredAnimal testEndangeredAnimal1 = new EndangeredAnimal("cat","okay","young");
//        testEndangeredAnimal1.save();
//        Sightings firstSightings = new Sightings(testEndangeredAnimal1.getId(),"Zone A","Lenny");
//        firstSightings.save();
//        Sightings secondSightings = new Sightings(testEndangeredAnimal1.getId(),"Zone A","Lenny");
//        secondSightings.save();
//        Sightings[] sightings = new Sightings[]{firstSightings,secondSightings};
//        assertTrue(testEndangeredAnimal1.getSightings().containsAll(Arrays.asList(sightings)));
//
//    }


    public EndangeredAnimal createEndangeredAnimal(){
        return new EndangeredAnimal("Lion","Ill", "New born");
    }
}