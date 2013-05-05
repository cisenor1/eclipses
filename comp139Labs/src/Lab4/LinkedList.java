package Lab4;

public class LinkedList<E> {
	private Node headOfList;
	private int itemCount;

	public LinkedList() {
		headOfList = null;
		itemCount = 0;
	}

	public void add(E theObject) {
		Node newBox = new Node(theObject);

		if (headOfList == null) {
			headOfList = newBox;
			itemCount++;
			return;
		}

		Node end = headOfList;
		while (end.next != null) {
			end = end.next;
		}

		end.next = newBox;

		itemCount++;
	}

	public E getPosition(int position) {
		if (position > itemCount - 1) {
			return null;
		}

		Node currentLink = headOfList;

		for (int index = 0; index < position; index++) {
			currentLink = currentLink.next;
		}

		return currentLink.thingToStore;
	}

	public int size() {
		return itemCount;
	}

	public void remove(int whichPosition) {
		if (whichPosition == 0) {
			headOfList = headOfList.next;
			itemCount--;
			return;
		}

		// Advance to the element just before the one we want to delete

		Node theOneBefore = headOfList;

		for (int index = 0; index < whichPosition - 1; index++) {
			theOneBefore = theOneBefore.next;
		}

		Node theOneToRemove = theOneBefore.next;
		Node theOneAfter = theOneToRemove.next;
		theOneBefore.next = theOneAfter;

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
			currentLink = currentLink.next;
		}

		return contents;
	}
	
	public void reverse(){
		
		if (itemCount <= 1){
			return;
		}
		
		Node current = headOfList;
		headOfList = headOfList.next;
		Node newList = current;
		newList.next = null;
		
		
		for (int i = 0; i < itemCount - 2; i++){ // Have the loop stop at the 2nd last item
			
			
			// set the current item to point at the new List.
			
			current = headOfList;
			headOfList = headOfList.next;
			
			// set newList to be the last on the new chain
			
			current.next = newList;
			newList = current;
			
		
			
		}
		// set the last item as the head of the new list.
		
		headOfList.next  = newList;
}

	private class Node {
		E thingToStore;
		Node next;

		Node(E what) {
			thingToStore = what;
			next = null;
		}
	}
}