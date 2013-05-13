package Lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BullyUtility {
	public static List<Bully> findWinners(List<Bully> players) {

		if (players.size() <= 1){
			return players;
		}
		
		
		Iterator<Bully> iter = players.iterator();
		Stack<Bully> stack = new Stack<Bully>();
		
		Bully challenger = iter.next();
		stack.add(challenger);
		
		for (int i = 1; i < players.size(); i++){ // i = 1 to exclude the first item.
			challenger = players.get(i);
			challenge(stack, challenger);
			
		}
		
		List<Bully> result = new ArrayList<Bully>();
		
		for(Bully player : players){
			if (player.getLunchMoney() != 0){
				result.add(player);
			}
		}
		
		
		
		
		
		
		return result;
	}

	public static void challenge(Stack<Bully> unbeatenBullies, Bully challenger) {

		if (unbeatenBullies.empty() == true) {
			unbeatenBullies.push(challenger);
			return;
		}

		Stack<Bully> tempStack = new Stack<Bully>();

		while (unbeatenBullies.empty() == false) {

			Bully tryMe = unbeatenBullies.pop();

			if (challenger.compareTo(tryMe) < 0) {

				// lose
				unbeatenBullies.add(tryMe);
				break;

			} else {

				// win
				tempStack.add(tryMe);
				challenger.addToPeoplePummeled(1);
				challenger.addToLunchMoney(tryMe.loseLunchMoney());
				

			}

		}
		unbeatenBullies.add(challenger);
		challenger.addToPeoplePummeled(1); // to count himself.

		while (tempStack.empty() == false) {
			Bully mover = tempStack.pop();
			unbeatenBullies.add(mover);
		}
		return;
	}
}
