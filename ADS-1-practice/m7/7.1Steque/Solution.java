import java.util.Scanner;
/**
 * Steque class contains methods such as push, pop and enqueue methods.
 */
class Steque {
    /**
     * private LinkedList object is created from the linked list class.
     */
    private LinkedList<String> list1 = new LinkedList<String>();
    /**
     * push method is used to push the element into the steque,
     * here we use linked list method insertAtStart to push element.
     * The time complexity is O(1) as we directly insert at start.
     *
     * @param element given.
     */
    public void push(final String element) {
        list1.insertAtStart(element);
        list1.display1();
    }
    /**
     * pop method is used to pop the element into the steque,
     * here we use linked list method deleteAtStart to pop the element.
     * the time complexity is O(1) as we directly delete the element at start.
     */
    public void pop() {
        list1.deleteAtStart();
        list1.display1();
    }
    /**
     * enqueue method is used to enter the element at the end of the steque,
     * here we use the linked list method insertAtEnd to insert the element.
     * the time complexity is O(n) as we have to traverse upto the last element.
     *
     * @param element that is to be inserted in stqueue.
     */
    public void enqueue(final String element) {
        list1.insertAtEnd(element);
        list1.display1();
    }
}

/**
 * Solution class contain main method and solution class.
 */
public final class Solution {
    /**
     * default constructor is private as others cannot use it from outside.
     */
    private Solution() {

    }
    /**
     * main method is used to handle input and output cases.
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
