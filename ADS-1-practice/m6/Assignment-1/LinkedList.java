class Node {
		String data;
		Node link;
}


class LinkedList {
	Node head;
	int size;
	void insertAtStart(String data) {
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
	void insertAtEnd(String data) {
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
	void insertAtPos(String data, int pos) {
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
	String deleteAtStart() {
		String str = "";
		if (size == 0) {
			return null;
		}
		Node node = new Node();
		str += "" + head.data;
		Node temp = head;
		temp = temp.link;
		head.link = null;
		head = temp;
		size--;
		return str;
	}
	String deleteAtEnd() {
		// if (size == 1) {
		// 	deleteAtStart();
		// 	break;
		// }
		String str = "";
		Node node = new Node();
		Node temp = head;
		while (temp.link.link != null) {
			temp = temp.link;
		}
		str = "" + temp.link.data;
		temp.link = null;
		//str += "" + temp.data;
		size--;
		return str;
	}
	String deleteAtPos(int pos) {
		String str = "";
		if (pos == 0) return null;
		if (pos == 1) {
			str += deleteAtStart();
			return str;
		}
		pos--;
		Node temp = head;
		while (pos != 1) {
			temp = temp.link;
			pos--;
		}
		str = "" + temp.link.data;
		temp.link = temp.link.link;
		size--;
		return str;
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

	String display1() {
		String str = "";
		if (size == 0) {
			return null;
		}
		if (head.link == null) {
			str = "" + head.data;
			return str;
		}
		Node temp = head;
		while (temp.link != null) {
			str += "" + temp.data;
			//System.out.println(str);
			temp = temp.link;
		}
		//System.out.println(temp.data);
		//System.out.println("inside:" + str);
		str += "" + temp.data;
		return str;
	}
}