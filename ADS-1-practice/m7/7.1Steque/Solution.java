import java.util.Scanner;
/**
 * Steque class.
 */
class Steque {
	LinkedList<String> list1 = new LinkedList<String>();
    /**
     * push method.
     *
     * @param element given.
     */
    public void push(final String element) {
    	list1.insertAtStart(element);
    	list1.display1();
    }
    /**
     * pop method.
     */
    public void pop() {
    	list1.deleteAtStart();
    	list1.display1();
    }
    /**
     * enqueue method.
     *
     * @param element given.
     */
    public void enqueue(final String element) {
    	list1.insertAtEnd(element);
    	list1.display1();
    }
}

/**
 * main Solution class.
 */
public final class Solution {
    /**
     * default constructor.
     */
    public Solution() {

    }
    /**
     * main method.
     *
     * @param args commandline arguments.
     */
	public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcase = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testcase; i++) {
        	Steque sque = new Steque();
        	while (scan.hasNext()) {
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
        	}
            System.out.println();
        }
	}
}