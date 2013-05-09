package Lab3;

public class LinkedList {
	private Node headOfList;
	private int itemCount;

	public LinkedList() {
		headOfList = null;
		itemCount = 0;
	}

	public LinkedList(LinkedList existingList){
		
		if (itemCount ==  0){
			headOfList = existingList.headOfList;
			itemCount++;
		}
		
		Node end = headOfList;
	}
	
	public void add(Object theObject) {
		Node newBox = new Node(theObject, null);

		if (itemCount == 0) {
			headOfList = newBox;
			itemCount++;
			return;
		}
		
		Node end = headOfList;
		while (end.getNext() != null) {
			end = end.getNext();
		}

		end.setNext(newBox);

		itemCount++;
	}

	public Object getPosition(int position) {
		if (position > itemCount - 1) {
			return null;
		}

		Node currentLink = headOfList;

		for (int index = 0; index < position; index++) {
			currentLink = currentLink.getNext();
		}

		return currentLink.getItem();
	}

	public int size() {
		return itemCount;
	}

	public void remove(int whichPosition) {
		if (whichPosition == 0) {
			headOfList = headOfList.getNext();
			itemCount--;
			return;
		}
		
		// Advance to the element just before the one we want to delete

		Node theOneBefore = headOfList;

		for (int index = 0; index < whichPosition - 1; index++) {
			theOneBefore = theOneBefore.getNext();
		}

		Node theOneToRemove = theOneBefore.getNext();
		Node theOneAfter = theOneToRemove.getNext();
		theOneBefore.setNext(theOneAfter);

		itemCount--;
	}

	@Override
	public String toString() {
		String contents = "";

		if (headOfList == null) {
			return "null";
		}

		Node currentLink = headOfList;

		for (int index = 0; index < itemCount; index++) {
			contents = contents + "[ " + currentLink.toString() + "] ";
			currentLink = currentLink.getNext();
		}

		return contents;
	}
}