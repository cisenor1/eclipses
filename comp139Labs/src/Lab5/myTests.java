package Lab5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class myTests {	
	
	Bully runt;
	Bully kong;
	
	Bully small;
	Bully medium;
	Bully large;
	
	Stack<Bully> unbeatenBullies;
	
	
	@Before
	public void setUp() throws Exception {
		runt = new Bully("Runt", 90, 10);
		kong = new Bully("Kong", 350, 1);
		
		small = new Bully("Small", 100, 5);
		medium = new Bully("Medium", 150, 10);
		large = new Bully("Large", 200, 15);
		
		unbeatenBullies = new Stack<Bully>();
}


	@Test
	public void challengeOneToEmpty() {
		
		
		BullyUtility.challenge(unbeatenBullies, runt);
		
		Stack<Bully> expectedResult = new Stack<>();
		expectedResult.add(runt);
		
		assertTrue(isSameStack(unbeatenBullies, expectedResult));
	}
	
	
	
	
	@Test
	public void challengeOneToSmaller(){
		
		unbeatenBullies.add(runt);
		BullyUtility.challenge(unbeatenBullies, small);
		
		Stack<Bully> expectedResult = new Stack<>();
		expectedResult.add(small);
		expectedResult.add(runt);
		
		assertTrue(isSameStack(unbeatenBullies, expectedResult));
		
		
	}
	
	@Test
	public void challengeOneToLarger(){
		
		unbeatenBullies.push(small);
		BullyUtility.challenge(unbeatenBullies, runt);
		
		Stack<Bully> expectedResult = new Stack<>();
		expectedResult.push(small);
		expectedResult.add(runt);
		
		assertTrue(isSameStack(unbeatenBullies, expectedResult));
		
		
	}
	
	@Test
	public void challengeSmallestToMany() {
		
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
	
	@Test
	public void challenge2ndSmallestToMany() {
		
		unbeatenBullies.add(large);
		unbeatenBullies.add(medium);
		unbeatenBullies.add(runt);
		
		BullyUtility.challenge(unbeatenBullies, small);
		
		Stack<Bully> expectedResult = new Stack<>();
		expectedResult.add(large);
		expectedResult.add(medium);
		expectedResult.add(small);
		expectedResult.add(runt);
		
		assertTrue(isSameStack(unbeatenBullies, expectedResult));
	}
	
	@Test
	public void challengeLargestToMany() {
		
		unbeatenBullies.add(medium);
		unbeatenBullies.add(small);
		unbeatenBullies.add(runt);
		
		BullyUtility.challenge(unbeatenBullies, large);
		
		Stack<Bully> expectedResult = new Stack<>();
		expectedResult.add(large);
		expectedResult.add(medium);
		expectedResult.add(small);
		expectedResult.add(runt);
		
		assertTrue(isSameStack(unbeatenBullies, expectedResult));
	}
	
	@Test
	public void findWinnerEmptyList(){
		List<Bully> initialBullies = new ArrayList<>();
		List<Bully> result = BullyUtility.findWinners(initialBullies);
		
		assertTrue(result.size() == 0);
	}
	
	@Test
	public void findWinnerOneOnList(){
		List<Bully> initialBullies = new ArrayList<>();
		initialBullies.add(runt);
		
		List<Bully> result = BullyUtility.findWinners(initialBullies);
		
		assertTrue(result.size() == 1);
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
}
