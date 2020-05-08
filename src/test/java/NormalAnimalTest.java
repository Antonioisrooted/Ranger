import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
public class NormalAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void NormalAnimal_instanceOfNormalAnimal_true(){
        NormalAnimal testNormalAnimal = createNormalAnimal();
        assertEquals(true, testNormalAnimal instanceof NormalAnimal);
    }
    @Test
    public void getMethods_returnTheRightValues()
    {   NormalAnimal testNormalAnimal = createNormalAnimal();
        assertEquals("Lion", testNormalAnimal.getName());
        assertEquals("Normal", testNormalAnimal.getType());
        assertEquals("Adult", testNormalAnimal.getAge());
        assertEquals("Healthy", testNormalAnimal.getHealth());
    }
    @Test
    public void equals_returnsTrueIfNamesAreTheSame_true(){
        NormalAnimal testNormalAnimal = createNormalAnimal();
        assertTrue(testNormalAnimal.equals(testNormalAnimal));
    }
    @Test
    public void save_savesNormalAnimalInstanceToDB_NormalAnimal(){
        NormalAnimal testNormalAnimal = createNormalAnimal();
        testNormalAnimal.save();
        assertTrue(NormalAnimal.all().get(0).equals(testNormalAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfNormalAnimal_true(){
        NormalAnimal testNormalAnimal = createNormalAnimal();
        testNormalAnimal.save();
        NormalAnimal testSecondNormalAnimal = createNormalAnimal();
        testSecondNormalAnimal.save();
        assertEquals(true, testNormalAnimal.all().get(0).equals(testNormalAnimal));
        assertEquals(true, testSecondNormalAnimal.all().get(1).equals(testSecondNormalAnimal));
    }
    @Test
    public void id_assignIdToSpecificInstance(){
        NormalAnimal testNormalAnimal = createNormalAnimal();
        testNormalAnimal.save();
        NormalAnimal savedNormalAnimal = NormalAnimal.all().get(0);
        assertEquals(testNormalAnimal.getId(), savedNormalAnimal.getId());
    }
//    @Test
//    public void getSighting_retrievesAllSightingFromDB_monsterList(){
//        NormalAnimal testNormalAnimal1 = new NormalAnimal("cat");
//        testNormalAnimal1.save();
//        Sightings firstSightings = new Sightings(testNormalAnimal1.getId(),"Zone A","Lenny");
//        firstSightings.save();
//        Sightings secondSightings = new Sightings(testNormalAnimal1.getId(),"Zone A","Lenny");
//        secondSightings.save();
//        Sightings[] sightings = new Sightings[]{firstSightings,secondSightings};
//        assertTrue(testNormalAnimal1.getSightings().containsAll(Arrays.asList(sightings)));
//
//    }
    public NormalAnimal createNormalAnimal()
    {
        return new NormalAnimal("Lion", "Adult", "Healthy");
    }
}