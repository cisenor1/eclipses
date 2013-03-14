import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Driver {
	
	public static void save(List<Patient> allPatients){
		
		String date = new SimpleDateFormat("YYYY-MM-dd_HHmm").format(new Date());
		String FileName = date + "_PatientLog.txt";
		
		
		File f = new File(FileName);
		if(f.exists()){
			FileName = date + "_PatientLog_1.txt";
		}
		
		Path path = Paths.get(FileName);
		Charset charset = Charset.forName("US-ASCII");
		
		
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)){
			for (Patient who : allPatients){
				String firstName = who.getfName();
				String lastName = who.getlName();
				String notes = who.getNotes();
				int age = who.getAge();
				
				Scanner scanner = new Scanner(notes);
				scanner.useDelimiter("\n");
				
				writer.write(lastName + ", " + firstName);
				writer.newLine();
				writer.write("Age: " + age);
				writer.newLine();
				writer.newLine();
				writer.write("Notes: ");
				writer.newLine();
				
				while (scanner.hasNext()){
					String note = scanner.next();
					writer.write(note);
					writer.newLine();	
				}
				scanner.close();
				writer.newLine();
				writer.write("=====================================================================");
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error with writer.");
			e.printStackTrace();
		}
		
	}

	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		List<Patient> allPatients = new ArrayList<Patient>();
		
		Patient anne = new Patient("Anne", "Anderson", 34);
		Patient ben	= new Patient("Ben", "Billows", "Has the flu", 54);
		Patient benA = new Patient("Ben", "Anderson", 32);
	
		System.out.println(anne);
		System.out.println(ben);
		
		ben.addNotes("Gave him meds. Is now 'feeling better'.");
		
		System.out.println(ben.getNotes());
		
		System.out.println();
		System.out.println();
		
		
		allPatients.add(anne);
		allPatients.add(benA);
		allPatients.add(ben);
		
		List<Patient> copy = new ArrayList<Patient>();
		
		for (Patient who : allPatients){
			copy.add(who);
		}
		
		for (Patient who : copy){
			System.out.println(who.getfName() + " " + who.getlName() + " is in the copy array.");
		}
		
		System.out.println();
		System.out.println();
		
		
		
		
		Comparator<Patient> byAge = Patient.byAge();

		Collections.sort(allPatients);
		
		Patient fakeBenA = new Patient("Ben", "Anderson", 0);
		int foundPosition = allPatients.indexOf(fakeBenA);
		Patient found = allPatients.get(foundPosition);
		found.addNotes("Came in with stomach pain.");
		
		
		save(allPatients);
		
		
		
		
		Collections.sort(allPatients, byAge);
		Iterator<Patient> iter = Patient.iterator(allPatients);
		
		while (iter.hasNext()){
			Patient who = iter.next();
			String fName = who.getfName();
			String lName = who.getlName();
			
			System.out.println(fName + " " + lName + "'s records are now on file.");
		}
		
		System.out.println();
		System.out.println();
		
		
		for (int i = 0; i < allPatients.size(); i++){
			
			Patient who = allPatients.get(i);
			
			String name = who.getfName() + " " + who.getlName();
			
			System.out.println(name + " has died from an unknown illness.");
			who.addNotes("DECEASED: Due to an unknown illness.");
		}
		
		System.out.println();
		System.out.println();
		
		save(allPatients);
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test"));  
        oos.writeObject(allPatients.toString());  
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test"));  
        System.out.println("from main: " + ois.readObject()); 
		oos.close();
		ois.close();


	}
}
