package Lab3;

class Node {
	Object	thingToStore;
	Node	nextOnList;

	Node(Object thingToStore, Node nextOnList) {
		this.thingToStore = thingToStore;
		this.nextOnList = nextOnList;
	}

	void setNext(Node nextOnList) {
		this.nextOnList = nextOnList;
	}

	Node getNext() {
		return nextOnList;
	}

	Object getItem() {
		return thingToStore;
	}

	@Override
	public String toString() {
		return thingToStore.toString();
	}
}