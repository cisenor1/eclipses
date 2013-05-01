package Lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class listTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test	
	public void onTheList(){

		
		ObjectList allItems;
		Person joe = new Person("Joe", "Watson");
		Person jane = new Person("Jane", "Dough");
		Person steve = new Person("Steve", "Wassisname");
		
		
		allItems = new ObjectList();
		allItems.add(joe);
		allItems.add(jane);
		allItems.add(steve);
		
		Person fakeJoe = new Person("Joe", "Watson");
		Person fakeJane = new Person("Jane", "Dough");
		Person fakeSteve = new Person("Steve", "Wassisname");
		
		assertTrue(allItems.indexOf(fakeJoe) == 0 );
		assertTrue(allItems.indexOf(fakeJane) == 1 );
		assertTrue(allItems.indexOf(fakeSteve) == 2 );
		
	}
	@Test
	public void notOnTheList() {
		
		ObjectList allItems;
		Person joe = new Person("Joe", "Watson");
		Person jane = new Person("Jane", "Dough");
		Person steve = new Person("Steve", "Wassisname");
		
		
		allItems = new ObjectList();
		allItems.add(joe);
		allItems.add(jane);
		allItems.add(steve);
		
		Person bob = new Person("Bob", "MacKenzie");
		
		assertTrue(allItems.indexOf(bob) == -1);
		
	}
	
	
	@Test
	public void insertAllMiddleTest(){

		ObjectList listOne = new ObjectList();
		ObjectList listTwo = new ObjectList();
		
		for (int i = 0; i < 10; i++){
			listOne.add(new Person("" + i, "" + i));
			listTwo.add(new Person("" + (100 + i), "" + (100 + i)));
		}
		
		Person target = (Person) listTwo.getPosition(0);
		
		listOne.insertAll(5, listTwo);
		
		assertTrue(listOne.getPosition(5).equals(target));
		
		
		
		
		
	}
	
	@Test
	public void insertAllEndTest(){

		ObjectList listOne = new ObjectList();
		ObjectList listTwo = new ObjectList();
		
		for (int i = 0; i < 10; i++){
			listOne.add(new Person("" + i, "" + i));
			listTwo.add(new Person("" + (100 + i), "" + (100 + i)));
		}

		Person target = (Person) listTwo.getPosition(0);
		
		listOne.insertAll(listOne.size(), listTwo);
		
		assertTrue(listOne.getPosition(10).equals(target));
		
		
		
		
		
	}
	
	@Test
	public void insertAllStartTest(){

		ObjectList listOne = new ObjectList();
		ObjectList listTwo = new ObjectList();
		
		for (int i = 0; i < 10; i++){
			listOne.add(new Person("" + i, "" + i));
			listTwo.add(new Person("" + (100 + i), "" + (100 + i)));
		}
		
		Person target = (Person) listOne.getPosition(0);
		
		listOne.insertAll(0, listTwo);
		assertTrue(listOne.getPosition(10).equals(target));
		
		
		
		
		
	}
	
	@Test
	public void insertAllIntoEmptyTest(){

		ObjectList listOne = new ObjectList();
		ObjectList listTwo = new ObjectList();
		
		for (int i = 0; i < 10; i++){
			listTwo.add(new Person("" + (100 + i), "" + (100 + i)));
		}
		
		Person target = (Person) listTwo.getPosition(0);
		
		listOne.insertAll(0, listTwo);
		assertTrue(listOne.getPosition(0).equals(target));
	}
	
	@Test
	public void insertAllEmptyTest(){

		ObjectList listOne = new ObjectList();
		ObjectList listTwo = new ObjectList();
		
		for (int i = 0; i < 10; i++){
			listOne.add(new Person("" + i, "" + i));
		}
		
		Person target = (Person) listOne.getPosition(9);
		
		listOne.insertAll(0, listTwo);
		assertTrue(listOne.getPosition(9).equals(target));
	}
	
	
	

	



}
