import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LoserDriver {

	public static void main(String[] args) {
		
		
		Loser jeff = new Loser("Jeff", 344);
		Loser anne = new Loser("Anne", 255);
		Loser beth = new Loser("Beth", 255);
		Loser charles = new Loser("Charles", 277);
		
		// Make an ArrayList of at least 4 losers with their initial weights.
		List<Loser> Losers = new ArrayList<Loser>(); 
		
		Losers.add(jeff);
		Losers.add(anne);
		Losers.add(beth);
		Losers.add(charles);
		
		jeff = null;
		anne = null;
		beth = null; 
		charles = null;
		
		
		// Write a “for each” loop that reduces the weight of each loser by 2 pounds.
		
		for (Loser who : Losers){
			who.setCurrentWeight(2);
		}
		
		
		// Use a for each loop to print out the complete list of losers.
		
		for (Loser who : Losers){
			System.out.println(who.getName());
		}
		
				
		// Locate the position of two different losers on the list. Retrieve those losers and change their current weight.
		
		Loser finder = new Loser("Jeff", 133);
		int foundPosition = Losers.indexOf(finder);
		Loser foundLoser = Losers.get(foundPosition);
		
		foundLoser.setCurrentWeight(120);
		
		
		Loser finder2 = new Loser("Charles", 133);
		int foundPosition2 = Losers.indexOf(finder2);
		Loser foundLoser2 = Losers.get(foundPosition2);
		
		foundLoser2.setCurrentWeight(121);
		
		Loser finder3 = new Loser("Anne", 133);
		int foundPosition3 = Losers.indexOf(finder3);
		Loser foundLoser3 = Losers.get(foundPosition3);
		
		foundLoser3.setCurrentWeight(118);
		
		
		
		// Use Collections.max to find the biggest loser and print that loser.
		
		System.out.println(Collections.max(Losers));
		
		
		// Sort the loser list and print it out again.
		
		Collections.sort(Losers);
		
		System.out.println("\nBefore the cut: ");
		
		for (Loser who : Losers){
			System.out.println(who.getName() + " lost " + who.getWeightDifference());
		}
		
		// Find the smallest loser. Use a counted loop to go through the list of losers. Remove them from the list, 
		// then print out their information. Note that ArrayList's remove has two different versions. In one version 
		// you give the position of the item you wish to remove. In the other version, you can pass the actual loser 
		// as an argument, which will use the Loser's equals method to find the correct item to remove from the list. 
		// When printing, use the getters for the loser rather than a toString.
		
		
		
		Loser smallestLoser = Losers.get(0);
		for (int i = 1; i < Losers.size(); i++) {
		Loser nextLoser = Losers.get(i);
		if (nextLoser.compareTo(smallestLoser) < 0) {
		smallestLoser = nextLoser;
		}


		}
		
		System.out.println("\n" + smallestLoser.getName() + " is the smallest Loser this round and is going home.");
		Losers.remove(smallestLoser);
		
		
		
		// Print out the list again to show that the smallest loser has been removed.
		
		System.out.println("\nAfter the cut: ");
		for (Loser who : Losers){
			System.out.println(who.getName() + " lost " + who.getWeightDifference());
		}

	}

}
