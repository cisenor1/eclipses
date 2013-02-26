import static org.junit.Assert.*;

import org.junit.Test;


public class ThrowerTest {

	@Test
	public void throwerInterface() {
		Thrower aThrower = new Thrower(3);
		assertTrue(aThrower instanceof ThrowerInterface);
	}
	
	@Test
	public void getsAll() {
		Thrower aThrower = new Thrower(3);
		
		assertTrue(aThrower.hasNext() == true);
		assertTrue(aThrower.next() == 3);
		
		assertTrue(aThrower.hasNext() == true);
		assertTrue(aThrower.next() == 2);
		
		assertTrue(aThrower.hasNext() == true);
		assertTrue(aThrower.next() == 1);
		
		assertTrue(aThrower.hasNext() == false);
	}

}
