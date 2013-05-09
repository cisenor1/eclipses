package Lab3;


import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MemberListTest {
	
	Worker fred;
	Worker sam;
	Worker joe;
	Worker pete;
	Worker george;
	
	LinkedList union;

	@Before
	public void setUp() throws Exception {
		
		fred = new Worker("Fred", "Maintenance");
		sam = new Worker("Sam", "Electrician");
		joe = new Worker("Joe", "Electrician");
		pete = new Worker("Pete", "Electrician");
		george = new Worker("George", "Electrician");
		
		union = new LinkedList();
	}
	
	@Test
	public void initialSizeEmpty() {
		assertTrue(union.size() == 0);
	}
	
	@Test
	public void addOneThenRetrieve() {
		union.add(fred);
		
		Worker who = (Worker) union.getPosition(0);
		assertTrue(who == fred);
		assertTrue(union.size() == 1);
	}
	
	@Test
	public void addMany() {
		union.add(fred);
		union.add(sam);
		
		assertTrue(union.size() == 2);
		assertTrue(union.getPosition(0) == fred);
		assertTrue(union.getPosition(1) == sam);
	}
	
	@Test
	public void removeBeginning() {
		union.add(fred);
		union.add(sam);
		union.add(joe);
		union.add(pete);
		union.add(george);
		assertTrue(union.size() == 5);
		
		union.remove(0);
		
		assertTrue(union.getPosition(0) == sam);
		assertTrue(union.getPosition(1) == joe);
		assertTrue(union.getPosition(2) == pete);
		assertTrue(union.getPosition(3) == george);
	}
	
	@Test
	public void removeMiddle() {
		union.add(fred);
		union.add(sam);
		union.add(joe);
		union.add(pete);
		union.add(george);
		assertTrue(union.size() == 5);
		
		union.remove(2);
		
		assertTrue(union.getPosition(0) == fred);
		assertTrue(union.getPosition(1) == sam);
		assertTrue(union.getPosition(2) == pete);
		assertTrue(union.getPosition(3) == george);		
	}

	@Test
	public void removeEnd() {
		union.add(fred);
		union.add(sam);
		union.add(joe);
		union.add(pete);
		union.add(george);
		assertTrue(union.size() == 5);
		
		union.remove(4);
		
		assertTrue(union.getPosition(0) == fred);
		assertTrue(union.getPosition(1) == sam);
		assertTrue(union.getPosition(2) == joe);
		assertTrue(union.getPosition(3) == pete);		
		
	}
	
	@Test
	public void copyIntoEmpty(){
		union.add(fred);
		union.add(sam);
		LinkedList list = new LinkedList(union);
		assertTrue(list.getPosition(0).equals(fred));
		assertTrue(list.getPosition(1).equals(sam));
		
		list.remove(0);
		assertTrue(list.getPosition(0).equals(sam));
		
	}
}
