package Lab4;


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
	
	public String getName() {
		return name;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	@Override
	public String toString() {
		return "name: " + name +
			" title: " + jobTitle;
	}
}