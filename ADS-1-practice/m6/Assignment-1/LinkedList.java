class LinkedList<E> {
    private Node head;
    private int size = 0;

	class Node {
		private E data;
		private Node next;
        Node(E data1) {
            this.data = data1;
            this.next = null;
        }
        public E getData() {
            return this.data;
        }
	}

	public void add(int pos, E item) {
		Node temp = new Node(item);
        if(pos < 0 || pos > size) {
            return;
        }
		if (pos == 0) {
            temp.next = head;
            head = temp;
            size++;
            return;
		}
        int count = 0;
        Node current = head;
        while (count++ < pos - 1) {
        	current = current.next; 
        }
        temp.next = current.next;
        current.next = temp;
        size++;
    }

	public E remove(int pos) {
        if (pos < 0 || pos > size) {
        	return null ;
        }
        // if (size == 1) {
        // 	head = null;
        //     size--;
        // 	return head.data;
        // }
        if (pos == 0) {
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }
        if (size == 1) {
            head = null;
            size--;
            return head.data;
        }
        //Node temp = new Node(item);
        Node current = head;
        int count = 0;
        while (count++ < pos - 1) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
        return current.data;

	}
    public int size() {
        return size;
    }

    public String display() {
        String s = "";
        if (size == 0) {
            return s;
        }
        if (size == 1) {
            s += head.data;
            return s;
        }
        Node current = head;
        int count = 0;
        while (count++ < size - 1) {
            s += current.data;
            //System.out.print(current.data + "->");
            current = current.next;
        }
        //System.out.println(current.data);
        s += current.data;
        return s;
          
    }

	public void retrive() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            System.out.println(head.data);
            return;
        }
		Node current = head;
        int count = 0;
        while (count++ < size - 1) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println(current.data);
	}
}

// class Solution1 {
// 	public static void main(String[] args) {
// 		LinkedList<Integer> l = new LinkedList<Integer>();
// 		l.add(0, 2);
//         l.retrive();
// 		l.add(1, 4);
//         l.retrive();
// 		l.add(2, 3);
//         l.retrive();
//         l.add(1,5);
//         l.retrive();
//         l.add(0,7);
//         l.retrive();
//         l.add(6,4);
//         //l.add(4,10);
//         l.remove(5);
//         l.retrive();
// 	}
// }
