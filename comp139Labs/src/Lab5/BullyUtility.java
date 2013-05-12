package Lab5;

import java.util.List;
import java.util.Stack;

public class BullyUtility {
	public static List<Bully> findWinners(List<Bully> players) {

		return null;
	}

	public static void challenge(Stack<Bully> unbeatenBullies, Bully challenger) {

		while (unbeatenBullies.empty() == false) {
			if (challenger.compareTo(unbeatenBullies.peek()) < 0) {
				unbeatenBullies.pop();
			} else {
				return;

			}
		}
	}
}
