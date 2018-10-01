import java.util.Scanner;
/**
 * Deque class contain methods such as push right, push left, pop left, pop left.
 */
class Deque {
    /**
     * creating the linked list class object to use it.
     */
    private LinkedList<Integer> l = new LinkedList<Integer>();
    /**
     * pushLeft method to push the element at start.
     *
     * @param num element to be pushed.
     */
    public void pushLeft(int num) {
        l.insertAtStart(num);
        l.display();
    }
    /**
     * pushRight method to push the element at start.
     *
     * @param num element to be pushed.
     */
    public void pushRight(int num) {
        l.insertAtEnd(num);
        l.display();
    }
    /**
     * popleft method is used to pop the element from left.
     */
    public void popLeft() {
        if (l.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        l.deleteAtStart();
        l.display();
    }
    /**
     * popRight method is used to pop the element from Right.
     */
    public void popRight() {
        if (l.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        l.deleteAtEnd();
        l.display();
    }
    /**
     * getSize give the size of deque.
     * @return size of deque.
     */
    public int getSize() {
        return l.size;
    }
}

/**
 * Solution class contain the main method.
 */
public final class Solution {
    /**
     * declaring default private constructor.
     */
    private Solution() {

    }
    /**
     * main method handles all the inputs and outputs.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        //Linkedlist<Integer> l = new Linkedlist<Integer>();
        Deque d = new Deque();
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] token = scan.nextLine().split(" ");
            switch (token[0]) {
                case "pushLeft":
                d.pushLeft(Integer.parseInt(token[1]));
                break;
                case "pushRight":
                d.pushRight(Integer.parseInt(token[1]));
                break;
                case "popLeft":
                d.popLeft();
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
