
public class Instructor implements InstructorInterface{

	private String name;
	private int dunks;
	private int moneyRaised;
	
	
	public Instructor(String inName){
		name = inName;
		dunks = 0;
		moneyRaised = 0;
	}
	
	@Override
	public int compareTo(InstructorInterface other) {
		int difference = moneyRaised - other.getMoneyRaised();
		if (difference != 0){
			return difference;
		}
		difference = dunks - other.getDunks();
		return difference;
	}

	@Override
	public void addToMoneyRaised(int amount) {
		moneyRaised += amount;
		
	}

	@Override
	public void wasDunked() {
		dunks++;
		
	}

	@Override
	public String getNickName() {
		return name;
	}

	@Override
	public int getMoneyRaised() {
		return moneyRaised;
	}

	@Override
	public int getDunks() {
		return dunks;
	}
	
	public boolean equals(InstructorInterface other){
		if (name.equals(other.getNickName()) == false){
				return false;
		}
		return true;
	}

}
