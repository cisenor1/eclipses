


public class Loser implements Comparable<Loser>{
	private int startingWeight;
	private String name;
	private int currentWeight;
	
	// Constructor creates start weight
	public Loser(String inName, int startWeight){
		name = inName;
		startingWeight = startWeight;
		currentWeight = startWeight;
	}
	
	// setters and getters
	
	public String getName() {
		return name;
	}
	
	public int getTotalWeightLost(){
		int totalLost = startingWeight - currentWeight;
		return totalLost;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public int getStartingWeight() {
		return startingWeight;
	}
	
	
	// Current weight can't be < 100
	
	// weightLost must be positive
	public void weightLost(int lost){
		if (currentWeight - lost < 100){
			return;
		}
		currentWeight -= lost;
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
		int myWeightLost = this.startingWeight - this.currentWeight;
		int otherWeightLost = other.startingWeight - other.currentWeight;
		
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
		return "Loser [startingWeight=" + startingWeight + ", name=" + name
				+ ", currentWeight=" + currentWeight + "]";
	}

	

}
