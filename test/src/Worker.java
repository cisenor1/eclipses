

public class Worker {

	private String name;
	private String jobTitle;

	public Worker(String aName, String aTitle) {
		name = aName;
		jobTitle = aTitle;
	}

	public void setTitle(String newTitle) {
		jobTitle = newTitle;
	}

	@Override
	public String toString() {
		return "name: " + name +
			"title: " + jobTitle;
	}
	
	public boolean equals(Object what){
		
		Worker who = (Worker) what;
		
		if (name.equals(who.name) == false){
			return false;
		}
		
		if (jobTitle.equals(who.jobTitle) == false){
			return false;
		}
		
		return true;
	}
}