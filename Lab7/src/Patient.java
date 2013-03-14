import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Patient implements Comparable<Patient>, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private String notes = "-None-";
	private int age;
	
	
	public Patient(String inFName, String inLName, String inNotes, int inAge){
		fName = inFName;
		lName = inLName;
		notes = new Date() + " : " + inNotes;
		age = inAge;
	}
	
	public Patient(String inFName, String inLName, int inAge){
		fName = inFName;
		lName = inLName;
		age = inAge;
	}



	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getNotes() {
		return notes;
	}


	public void addNotes(String inNotes) {
		if (notes.equals("-None-")){
			notes = new Date() + " : " + inNotes;
			return;
		}
		notes = new Date() + " : " + inNotes + "\n" + notes;
	}
	
	public int getAge(){
		return age;
	}
	
	public boolean equals(Object what){
		Patient other = (Patient) what;
		String myFName = fName;
		String otherFName = other.getfName();
		String myLName = lName;
		String otherLName = other.getlName();
		
		if (!myFName.equals(otherFName)){
			return false;
		}
		
		if (!myLName.equals(otherLName)){
			return false;
		}
		
		return true;
		
		
		
	}
	@Override
	public int compareTo(Patient what){
		
		Patient who = (Patient) what;
		int difference = lName.compareTo(who.getlName());
		if (difference != 0){
			return difference;
		}
		difference = fName.compareTo(who.getfName());
		if (difference  != 0){
			return difference;
		}
		
		difference = (age - who.getAge());
		
		return difference;
	}
	
	
	public static Comparator<Patient> byAge(){
		return new Comparator<Patient>() {
			public int compare(Patient a, Patient b) {
				int difference = (a.getAge() - b.getAge());
					if (difference != 0){
						return difference;
					}
				String aLastName = a.getlName();
				String bLastName = b.getlName();
				
				
				difference = aLastName.compareTo(bLastName);
				
				return difference;
			}
		};
			

		}
	
	public static Iterator<Patient> iterator(List<Patient> allPatients) {
		Collections.sort(allPatients);
		return allPatients.iterator();
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {    
        System.out.println("from Patient.writeObject: " + this);   
        out.writeObject(this);  
    }  
  
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {  
        Patient d = (Patient) in.readObject();  
        System.out.println("from Patient.readObject: " + d);
    }  

	
	
	

	@Override
	public String toString() {
		return "Patient [First Name: " + fName + ", Last Name: " + lName + ", notes: "
				+ notes + ", age: " + age + "]";
	}
	

}
