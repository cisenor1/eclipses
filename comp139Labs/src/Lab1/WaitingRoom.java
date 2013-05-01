package Lab1;

import java.util.ArrayList;

public class WaitingRoom {

	/**
	 * A simple driver to test speed of sorting and finding in an array
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Person> list = new ArrayList<Person>();

		Person joe = new Person("Joe", "Johnson");

		int TEST_NUM = 200000;
		
		System.out.println("Start add");

		for (int i = 0; i < TEST_NUM; i++) {
			list.add(joe);
		}
		
		System.out.println("done add");
		
		System.out.println("Start remove");

		for (int i = 0; i < TEST_NUM; i++) {
			list.remove(0);
		}
		
		System.out.println("done remove");

	}

}
