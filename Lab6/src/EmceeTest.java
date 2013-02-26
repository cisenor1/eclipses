import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class EmceeTest {
	
	Emcee host;
	
	Thrower aThrower;
	Thrower bThrower;
	Thrower cThrower;
	
	Instructor aInstructor;
	Instructor bInstructor;
	Instructor cInstructor;


	@Before
	public void setUp() throws Exception {
		host = new Emcee();
		
		aThrower = new Thrower(3);
		bThrower = new Thrower(3);
		cThrower = new Thrower(3);
		
		aInstructor = new Instructor("a");
		bInstructor = new Instructor("b");
		cInstructor = new Instructor("c");
	}
	
	@Test
	public void emceeInterface() {
		ThrowerInterface currentThrower = host.getCurrentThrower();
		assertTrue(currentThrower instanceof ThrowerInterface);
	}

	@Test
	public void initalized() {
		ThrowerInterface currentThrower = host.getCurrentThrower();
		assertTrue(currentThrower.hasNext() == false);
		
		Iterator<Instructor> iter = host.iterator();
		assertTrue(iter.hasNext() == false);
		
		InstructorInterface victim = host.getCurrentVictim();
		String name = victim.getNickName();
		assertTrue(name.equals(""));
	}
	
	@Test
	public void oneThrower() {
		host.throwerStepsUp(aThrower);
		assertTrue(host.getCurrentThrower() == aThrower);
		
		host.throwerChoosesVictim(aInstructor);
		assertTrue(host.getCurrentVictim() == aInstructor);
		
		assertTrue(host.throwAnother(200) == true);
		InstructorInterface who = host.getCurrentVictim();
		assertTrue(who.getMoneyRaised() == 200);
		assertTrue(who.getDunks() == 0);
		
		host.dunked();
		
		who = host.getCurrentVictim();
		assertTrue(who.getMoneyRaised() == 200);
		assertTrue(who.getDunks() == 1);
	}
	
	@Test
	public void twoThrowers() {
		oneThrower();
		
		host.throwerStepsUp(bThrower);
		assertTrue(host.getCurrentThrower() == bThrower);

		host.throwerChoosesVictim(bInstructor);
		assertTrue(host.getCurrentVictim() == bInstructor);
		
		assertTrue(host.throwAnother(300) == true);
		host.dunked();
		InstructorInterface who = host.getCurrentVictim();
		assertTrue(who.getMoneyRaised() == 300);
		assertTrue(who.getDunks() == 1);
	}
	
	@Test
	public void iteratorInterface() {
		assertTrue(host instanceof Iterable);
	}
	
	@Test
	public void iteratorOrder() {
		host.throwerStepsUp(aThrower);
		host.throwerChoosesVictim(aInstructor);

		assertTrue(host.throwAnother(200) == true);
		
		host.throwerStepsUp(bThrower);
		host.throwerChoosesVictim(bInstructor);

		assertTrue(host.throwAnother(200) == true);
		assertTrue(host.throwAnother(200) == true);
		assertTrue(host.throwAnother(200) == true);
		assertTrue(host.throwAnother(200) == false);
		
		host.throwerStepsUp(cThrower);
		host.throwerChoosesVictim(cInstructor);

		assertTrue(host.throwAnother(200) == true);
		assertTrue(host.throwAnother(200) == true);

		Iterator<Instructor> iter = host.iterator();
		
		assertTrue(iter.next() == bInstructor);
		assertTrue(iter.next() == cInstructor);
		assertTrue(iter.next() == aInstructor);
		
		assertTrue(iter.hasNext() == false);
		
		assertTrue(host.getTotalFundsRaised() == 6 * 200);
	}
}
