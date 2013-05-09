package Lab2;


public class ObjectList {
	private static final int MAX_ITEMS = 20;

	private Object[] allItems;
	private int nextEmptySlot;

	public ObjectList() {
		allItems = new Object[MAX_ITEMS];
		nextEmptySlot = 0;
	}

	public void add(Object what) {
		  if(nextEmptySlot == allItems.length) {
		    grow();
		    }

		  allItems[nextEmptySlot] = what;
		  nextEmptySlot++;
		  }

	private void grow() {
		Object [] newItems = new Object[allItems.length * 2];

	  for(int copyIndex = 0; copyIndex < allItems.length; copyIndex++) {
	    newItems[copyIndex] = allItems[copyIndex];
	    }

	  allItems = newItems;
	  }

	public void remove(int removePosition) {
		int positionToMove = removePosition + 1;
		int lastPositionToMove = nextEmptySlot - 1;
		int itemsToMove = lastPositionToMove - positionToMove + 1;
		
		for (int i = 0; i < itemsToMove; i++) {
			allItems[positionToMove - 1] = allItems[positionToMove];
			positionToMove++;
		}
		
		nextEmptySlot--;
		allItems[nextEmptySlot] = null;
	}

	public Object getPosition(int position) {
		return allItems[position];
	}

	public int size() {
		return nextEmptySlot;
	}

	public String toString() {
		String theMembers = "";
		for (int memberNumber = 0; memberNumber < nextEmptySlot; memberNumber++) {
			theMembers = theMembers + " [ " + allItems[memberNumber] + " ] ";
		}

		return theMembers;
	}
	
	public int indexOf(Object what){
		
		int pos;
		
		for(pos = 0; pos < nextEmptySlot; pos++){ 
			if (what.equals(allItems[pos])){
				
				return pos;
			}

		}

		return -1;
	}
	
	public void insertAll(int position, ObjectList otherList){
		
		int otherSize = otherList.nextEmptySlot;
		int thisRemainingSpaces = allItems.length - nextEmptySlot;
		
		while (otherSize >= thisRemainingSpaces){
			
			grow();
			thisRemainingSpaces = allItems.length - nextEmptySlot;
		}
		
		int posToBeMoved = nextEmptySlot - 1;
		int posToBeMovedTo;
		
		while (posToBeMoved >= position) {
			
			posToBeMovedTo = posToBeMoved + otherSize;
			
			allItems[posToBeMovedTo] = allItems[posToBeMoved];
			
			posToBeMoved--;
			
		}
		
		for(int copyIndex = 0; copyIndex < otherSize; copyIndex++){
			
			allItems[position] = otherList.getPosition(copyIndex);
			nextEmptySlot++;
			position++;
		}
		
	}
}

	