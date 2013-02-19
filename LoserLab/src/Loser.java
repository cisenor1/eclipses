


public class Loser implements Comparable<Loser>{
	private int startWeight;
	private String name;
	private int currentWeight;
	
	// Constructor creates start weight
	public Loser(String inName, int inStartWeight){
		name = inName;
		startWeight = inStartWeight;
		currentWeight = startWeight;
	}
	
	// setters and getters
	
	public String getName() {
		return name;
	}

	public int getStartWeight() {
		return startWeight;
	}
	
	public int getWeightDifference(){
		int totalLost = startWeight - currentWeight;
		return totalLost;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}
	
	
	// Current weight can't be < 100
	
	// weightLost must be positive
	public void setCurrentWeight(int inCurrentWeight){
		if (inCurrentWeight < 100){
			return;
		}
		currentWeight = inCurrentWeight;
	}
	
	// The Class is to be sorted
	
	// write an equals method
	@Override
	public boolean equals(Object what) {
		Loser other = (Loser) what;
		
		if( ! name.equals(other.name)) {
			return false;
		
		}
		
		return true;
	}
		
	// implements Comparable<Loser> : write comparableTo method
	//  compareTo returns the difference between weight. Ordered from least to most lost, then by name
	@Override
	public int compareTo(Loser other){
		int myWeightLost = this.startWeight - this.currentWeight;
		int otherWeightLost = other.startWeight - other.currentWeight;
		
		int difference = myWeightLost - otherWeightLost;
		if (difference != 0){
		return difference;
		}
		difference = name.compareTo(other.name);
		return difference;
	}
	
	// 
	
	@Override
	public String toString() {
		return "Loser [startingWeight=" + startWeight + ", name=" + name
				+ ", currentWeight=" + currentWeight + "]";
	}


	

}
