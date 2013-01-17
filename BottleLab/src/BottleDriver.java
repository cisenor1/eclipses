
public class BottleDriver {
	
	public static void main(String[] args) {
		
		// Make a new bottle with name
		Bottle aBottle = new Bottle("Aquafina", 1000);
		
		
		// Find out how much water is in it
		aBottle.getCurrentAmountInBottle();
		
		// Add water to it
		
		aBottle.addWaterToBottle(300);
		aBottle.addWaterToBottle(300);
		aBottle.addWaterToBottle(300);
		aBottle.addWaterToBottle(300);
		
		// Pour some out
		aBottle.pourWaterOut(200);
		aBottle.pourWaterOut(200);
		aBottle.pourWaterOut(200);
		aBottle.pourWaterOut(2000);
		aBottle.pourWaterOut(200);
		
		// Pour until empty
		//aBottle.pourWaterOut(1000);
		
		// Fill until full
		//aBottle.addWaterToBottle(1200);
		
	}

}
