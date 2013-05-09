package Lab2;

public class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private static int numOfEquals = 0;

	public static int getNumOfEquals() {
		return numOfEquals;
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	@Override
	public boolean equals(Object who) {
		
		Person target = (Person) who;
		numOfEquals++;
		
		
		if (lastName.equals(target.lastName) == false){
			return false;
		}
		
		if (firstName.equals(target.firstName) == false){
			return false;
		}
		
		
		
		return true;
		
	}

	public String toString() {
		String ret = lastName + ", " + firstName;
		return ret;

	}

	@Override
	public int compareTo(Person other) {
		int difference;

		difference = lastName.compareTo(other.lastName);

		if (difference != 0) {
			return difference;
		}
		
		difference = firstName.compareTo(other.firstName);

		return difference;
	}
}
