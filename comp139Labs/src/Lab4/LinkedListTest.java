package Lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {
	
	LinkedList<Worker> aList;
	
	Worker a;
	Worker b;
	Worker c;
	Worker d;
	Worker e;

	@Before
	public void setUp() throws Exception {
		aList = new LinkedList<Worker>();
		
		a = new Worker("a", "a");
		b = new Worker("b", "b");
		c = new Worker("c", "c");
		d = new Worker("d", "d");
		e = new Worker("e", "e");
		
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
	}
	
	@Test
	public void reverseLongList() {
		
		aList.reverse();
		
		assertTrue(aList.size() == 5);
		
		assertTrue(aList.getPosition(0) == e);
		assertTrue(aList.getPosition(1) == d);
		assertTrue(aList.getPosition(2) == c);
		assertTrue(aList.getPosition(3) == b);
		assertTrue(aList.getPosition(4) == a);
	}
	
	@Test
	public void reverseEmpty() {
		aList = new LinkedList<Worker>();
		
		aList.reverse();
		
		assertTrue(aList.size() == 0);
	}
	
	@Test
	public void reverseOneItem() {
		aList = new LinkedList<Worker>();
		
		aList.add(a);
		
		aList.reverse();
		
		assertTrue(aList.size() == 1);
		
		assertTrue(aList.getPosition(0) == a);
	}
	
	@Test
	public void reverseTwoItems() {
		aList = new LinkedList<Worker>();
		
		aList.add(a);
		aList.add(b);
		
		aList.reverse();
		
		assertTrue(aList.size() == 2);
		
		assertTrue(aList.getPosition(0) == b);
		assertTrue(aList.getPosition(1) == a);
	}
	
	@Test
	public void reverseThreeItems() {
		aList = new LinkedList<Worker>();
		
		aList.add(a);
		aList.add(b);
		aList.add(c);
		
		aList.reverse();
		
		assertTrue(aList.size() == 3);
		
		assertTrue(aList.getPosition(0) == c);
		assertTrue(aList.getPosition(1) == b);
		assertTrue(aList.getPosition(2) == a);
	}


}
