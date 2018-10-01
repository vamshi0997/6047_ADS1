import java.util.Scanner;
class Deque {
	LinkedList<Integer> l = new LinkedList<Integer>();
	public void pushLeft(int num) {
		l.insertAtStart(num);
		l.display();
	}
	public void pushRight(int num) {
		l.insertAtEnd(num);
		l.display();
	}
	public void popLeft() {
		l.deleteAtStart();
		l.display();
	}
	public void popRight() {
		l.deleteAtEnd();
		l.display();
	}
	public int getSize() {
		return l.size;
	}
}


class Solution {
	public static void main(String[] args) {
		//Linkedlist<Integer> l = new Linkedlist<Integer>();
		Deque d = new Deque();
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		while(scan.hasNext()) {
			String[] token = scan.nextLine().split(" ");
			switch(token[0]) {
				case "pushLeft":
				d.pushLeft(Integer.parseInt(token[1]));
				break;
				case "pushRight":
				d.pushRight(Integer.parseInt(token[1]));
				break;
				case "popLeft":
				d.popRight();
				break;
				case "popRight":
				d.popRight();
				break;
				case "size":
				System.out.println(d.getSize());
				break;
				default:
				break;
			}
		}
	}
}