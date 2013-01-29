import static org.junit.Assert.*;

import org.junit.Test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LoserTest {
    
    Loser fred;

    @Before
    public void setUp() throws Exception {
        
        fred = new Loser("Fred", 150);
    }
    
    @Test
    public void constructorWorks() {
        String name = fred.getName();
        assertTrue(name.equals("Fred"));
        
        assertTrue(fred.getStartWeight() == 150);
        assertTrue(fred.getCurrentWeight() == 150);
    }
    
    @Test
    public void implementsComparable() {
        assertTrue(fred instanceof Comparable);
    }
    
    @Test
    public void getSet() {
        assertTrue(fred.getStartWeight() == 150);
        assertTrue(fred.getCurrentWeight() == 150);
        assertTrue(fred.getWeightDifference() == 0);
        
        fred.setCurrentWeight(100);
        assertTrue(fred.getStartWeight() == 150);
        assertTrue(fred.getCurrentWeight() == 100);        
        assertTrue(fred.getWeightDifference() == 50);
    }
    
    @Test
    public void compareToWorksByLoss() {
        Loser personSmall = new Loser("Small",101);
        personSmall.setCurrentWeight(100);
        
        Loser personLarge = new Loser("Large", 200);
        personLarge.setCurrentWeight(150);
        
        int comparison = personLarge.compareTo(personSmall);
        assertTrue(comparison == 49);
        
        comparison = personSmall.compareTo(personLarge);
        assertTrue(comparison == -49);
        
        assertTrue(personSmall.compareTo(personSmall) == 0);
    }
    
    @Test
    public void compareToWorksByNameWhenLossEqual() {
        Loser smith = new Loser("Smith", 150);
        smith.setCurrentWeight(100);
        
        Loser jones = new Loser("Jones", 150);
        jones.setCurrentWeight(100);
        
        assertTrue(smith.compareTo(jones) > 0);
        assertTrue(jones.compareTo(smith) < 0);
    }
}