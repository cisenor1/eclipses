package Lab4;

public class LinkedListDriver {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int LOTS_ = 10000;
		LinkedList<Worker> aList = new LinkedList<Worker>();
		
		for(int i = 0; i < LOTS_; i++){
			aList.add(new Worker("" + i, ""+i));
		}
		
		System.out.println("finished adding.");
		
		
		
		listReverse(aList);
		
		System.out.println("Done");
		
		
	}

	public static LinkedList<Worker> listReverse(LinkedList<Worker> inList){
		
		
		Worker storage;
		
		int size = inList.size();
		int lastOne = size - 1;
		
		for (int i = 0; i <= size; i++){
			
			int indexToRemove = lastOne - i;
			
			storage = inList.getPosition(indexToRemove);
			inList.remove(indexToRemove);
			inList.add(storage);
			
			
			
		}
		
		
		
		
		return inList;
	}

}
