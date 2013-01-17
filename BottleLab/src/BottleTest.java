import static org.junit.Assert.*;

import org.junit.Test;


public class BottleTest {

	@Test
	public void initBottle() {
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		String name = aBottle.getBottleName();
		assertTrue(name == "Aquafina");
		
		int volume = aBottle.getTotalVolume();
		assertTrue(volume == 1000);
	}
	
	@Test
	public void addWater(){
		
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		aBottle.addWaterToBottle(300);
		assertTrue(aBottle.getCurrentAmountInBottle() == 300);
	}
	
	@Test
	public void pourWater(){
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		aBottle.addWaterToBottle(300);
		aBottle.pourWaterOut(200);
		
		assertTrue(aBottle.getCurrentAmountInBottle() == 100);
	}
	
	@Test
	public void emptyTest(){
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		aBottle.addWaterToBottle(0);
		boolean empty = aBottle.isItEmpty();
		assertTrue(empty == true);
	}
	
	@Test
	public void fullTest(){
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		aBottle.addWaterToBottle(1000);
		boolean full = aBottle.isItFull();
		assertTrue(full == true);
	}
	
	@Test
	public void anyOverflow(){
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		aBottle.addWaterToBottle(10000);
		int overflow = aBottle.getCurrentAmountInBottle();
		assertTrue(overflow == aBottle.getTotalVolume());
	}
	
	@Test
	public void isItDrained(){
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		aBottle.pourWaterOut(200000);
		int drained = aBottle.getCurrentAmountInBottle();
		assertTrue(drained == 0);
	}

}
