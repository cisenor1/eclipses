package Lab1;

import java.util.ArrayList;
import java.util.Collections;

public class WaitingRoomEquals {

	/**
	 * A simple driver to test speed of sorting and finding in an array
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		

		ArrayList<Person> list = new ArrayList<Person>();
		
		int TEST_NUM = 5000000;

		System.out.println("Start add");

		for (int i = 0; i <= TEST_NUM; i++) {
			String number = "" + i;
			Person guy = new Person("Guy", number);

			list.add(guy);
		}
		
		System.out.println("Finished add");
		System.out.println("Start indexOf");
		
		
		Collections.shuffle(list);
		
		int pos = list.indexOf(new Person("Guy", "888888"));

		System.out.println("Used " + Person.getNumOfEquals() + " equals to find Guy at position " + pos);

	}


}
