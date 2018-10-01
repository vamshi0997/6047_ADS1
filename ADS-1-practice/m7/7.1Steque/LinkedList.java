class LinkedList<E> {
	class Node {
		E data;
		Node link;
	}
	Node head;
	int size;
	void insertAtStart(E data) {
		Node node = new Node();
		size++;
		if (head == null) {
			node.data = data;
			node.link = null;
			head = node;
		} else {
			node.data = data;
			node.link = head;
			head = node;
		}
	}
	void insertAtEnd(E data) {
		Node node = new Node();
		size++;
		if (head == null) {
			node.data = data;
			node.link = null;
			head = node;
		} else {
			Node temp = head;
			while (temp.link != null) {
				temp = temp.link;
			}
			node.data = data;
			temp.link = node;
			node.link = null;
		}
	}
	void insertAtPos(E data, int pos) {
		Node node = new Node();
		if (pos == 0) {
			return;
		}
		if (pos == 1) {
			insertAtStart(data);
			return;
		}
		pos--;
		Node temp = head;
		while (pos != 1) {
			temp = temp.link;
			pos--;
		}
		node.data = data;
		node.link = temp.link;
		temp.link = node;
		size++;
	}
	void deleteAtStart() {
		if (size == 0) {
			return;
		}
		Node node = new Node();
		Node temp = head;
		temp = temp.link;
		head.link = null;
		head = temp;
		size--;
	}
	void deleteAtEnd() {
		Node node = new Node();
		Node temp = head;
		while (temp.link.link != null) {
			temp = temp.link;
		}
		temp.link = null;
		size--;
	}
	void deleteAtPos(int pos) {
		if (pos == 0) return;
		if (pos == 1) {
			deleteAtStart();
			return;
		}
		pos--;
		Node temp = head;
		while (pos != 1) {
			temp = temp.link;
			pos--;
		}
		temp.link = temp.link.link;
		size--;
	}
	void display() {
		if (size == 0) {
			System.out.println("Empty");
			return;
		}
		if (head.link == null) {
			System.out.println(head.data);
			return;
		}
		Node temp = head;
		while (temp.link != null) {
			System.out.print(temp.data + "->");
			temp = temp.link;
		}
		System.out.println(temp.data);
	}

	void display1() {
		if (size == 0) {
			System.out.println("Steque is empty");
			return;
		}
		if (head.link == null) {
			System.out.println(head.data);
			return;
		}
		Node temp = head;
		while (temp.link != null) {
			System.out.print(temp.data + ",");
			temp = temp.link;
		}
		System.out.println(temp.data);
	}
}