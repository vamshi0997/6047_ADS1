import java.util.Scanner;
class Steque {
	LinkedList<String> list1 = new LinkedList<String>();
    public void push(String element) {
    	list1.insertAtStart(element);
    	list1.display1();
    }
    public void pop() {
    	list1.deleteAtStart();
    	list1.display1();
    }
    public void enqueue(String element) {
    	list1.insertAtEnd(element);
    	list1.display1();
    }
}

class Solution {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcase = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testcase; i++) {
        	Steque sque = new Steque();
        	while(scan.hasNext()) {
        		String line = scan.nextLine();
        		if (line.equals("")) {
        			break;
        		}
        		String[] token = line.split(" ");
        		switch (token[0]) {
                    case "push":
                    sque.push(token[1]);
                    break;
                    case "pop":
                    sque.pop();
                    break;
                    case "enqueue":
                    sque.enqueue(token[1]);
                    break;
                    default:
                    break;
        		}
                System.out.println();
        	}
        }
	}
}