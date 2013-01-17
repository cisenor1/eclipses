
public class Bottle {
	
	private String bottleName;
	private int totalVolume;
	private int currentAmountInBottle;
	
	
	public void bottle(String inName, int size){
		bottleName = inName;
		totalVolume = size;
		
	}


	public String getBottleName() {
		return bottleName;
	}


	public int getTotalVolume() {
		return totalVolume;
	}


	public int getCurrentAmountInBottle() {
		return currentAmountInBottle;
	}

}
