package Lab5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;


public class BullyUtilityTest {
	Bully runt;
	Bully kong;

	Bully small;
	Bully medium;
	Bully large;

	Stack<Bully> unbeatenBullies;


	@Before
	public void setUp() throws Exception {
		runt = new Bully("Runt", 99, 10);
		kong = new Bully("Kong", 350, 1);
		
		small = new Bully("Small", 100, 5);
		medium = new Bully("Medium", 150, 10);
		large = new Bully("Large", 200, 15);
		
		unbeatenBullies = new Stack<Bully>();
	}
	
	@Test
	public void challenge() {
		
		unbeatenBullies.add(large);
		unbeatenBullies.add(medium);
		unbeatenBullies.add(small);
		
		BullyUtility.challenge(unbeatenBullies, runt);
		
		Stack<Bully> expectedResult = new Stack<>();
		expectedResult.add(large);
		expectedResult.add(medium);
		expectedResult.add(small);
		expectedResult.add(runt);
		
		assertTrue(isSameStack(unbeatenBullies, expectedResult));
	}

	private boolean isSameStack(Stack<Bully> a, Stack<Bully> b) {
		boolean isSame = true;
		
		Iterator<Bully> iter = a.iterator();
		for(Bully who : b) {
			if(who != iter.next()) {
				return false;
			}
		}		
		return isSame;
	}

	@Test
	public void findWinners() {
		List<Bully> initialBullies = new ArrayList<>();
		
		initialBullies.add(small);
		initialBullies.add(medium);
		initialBullies.add(large);
		initialBullies.add(kong);
		
		List<Bully> result = BullyUtility.findWinners(initialBullies);
		
		assertTrue(result.size() == 1);
		Bully onlyOne = result.get(0);
		assertTrue(onlyOne == kong);
		int pummelCount = kong.getPeoplePummeled();
		assertTrue(pummelCount == 4);
		assertTrue(kong.getLunchMoney() == 31);
	}
	
	@Test
	public void findWinnersTwo() {
		List<Bully> initialBullies = new ArrayList<>();

		initialBullies.add(large);
		initialBullies.add(kong);
		initialBullies.add(small);
		initialBullies.add(medium);

		List<Bully> result = BullyUtility.findWinners(initialBullies);

		assertTrue(result.size() == 2);
		assertTrue(result.get(0) == kong);
		assertTrue(result.get(1) == medium);
	}

	@Test
	public void findWinnersThree() {
		List<Bully> initialBullies = new ArrayList<>();

		initialBullies.add(large);
		initialBullies.add(small);
		initialBullies.add(kong);
		initialBullies.add(medium);

		List<Bully> result = BullyUtility.findWinners(initialBullies);

		assertTrue(result.size() == 2);
		assertTrue(result.get(0) == kong);
		assertTrue(result.get(1) == medium);
	}
	
	@Test
	public void findWinnersFour() {
		List<Bully> initialBullies = new ArrayList<>();

		initialBullies.add(kong);
		initialBullies.add(small);
		initialBullies.add(medium);
		initialBullies.add(large);

		List<Bully> result = BullyUtility.findWinners(initialBullies);

		assertTrue(result.size() == 2);
		assertTrue(result.get(0) == kong);
		assertTrue(result.get(1) == large);
	}

}




