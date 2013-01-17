
public class Bottle {
	
	private String bottleName;
	private int totalVolume;
	private int currentAmountInBottle = 0;
	private boolean isEmpty;
	private boolean isFull;
	
	
	public Bottle(String inName, int size){
		bottleName = inName;
		totalVolume = size;
		updateBottle();
		
		
	}
	
	public boolean isItEmpty(){
		if(currentAmountInBottle < 1){
			isEmpty = true;
		}
		else {
			isEmpty = false;
		}
		return isEmpty;
	}
	
	public boolean isItFull(){
		if(currentAmountInBottle >= totalVolume){
			isFull = true;
		}
		else {
			isFull = false;
		}
		return isFull;
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
	
	public void addWaterToBottle(int howMuch){
		for(int i = 0; i < howMuch; i++){
			if(! isItFull()){
				currentAmountInBottle++;
			}
		}
		updateBottle();
		
	}
	
	public void pourWaterOut(int howMuch){
		for(int i = 0; i < howMuch; i++){
			if(! isItEmpty()){
			currentAmountInBottle--;
			}
		}
		if(currentAmountInBottle < 1){
			currentAmountInBottle = 0;
		}
		updateBottle();
	}
	
	public void updateBottle(){
		isItFull();
		isItEmpty();
	}
}
