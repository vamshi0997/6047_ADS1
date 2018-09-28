import java.util.Scanner;
//import java.util.Arrays;

/**
 * LinkedStack contain pop and push methods.
 */
class LinkedStack <E> {
    /**
     * Node first always points to top node in list.
     */
    private Node<E> first = null;
    /**
     * class node creates a new node each time.
     */
    class Node<E> {
        /**
         * String item name.
         */
        private E item;
        /**
         * Node next.
         */
        private Node<E> next;
        /**
         * returns the node name.
         * @return node.
         */
        public E getName() {
            return this.item;
        }
    }
    /**
     * check whether stack is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * push method is used to push the item.
     * @param E element to push.
     */
    public void push(final E item) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldfirst;
    }
    /**
     * pop method is to remove the item.
     * @return the poped element.
     */
    public E pop() {
        E item = first.item;
        first = first.next;
        return item;
    }
    /**
     * Gives the top node.
     * @return first or top Node.
     */
    public Node<E> getFirst() {
        return first;
    }
}
/**
 * Solution class contain main method and other methods.
 */
 public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main takes input from user and prints output to console.
     *
     * @param      args  The commandline arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        LinkedStack<Integer> link = new LinkedStack<Integer>();
        for (int i = 0; i < s.length; i++) {
            try {
                link.push(Integer.parseInt(s[i]));
            } catch (Exception e) {
                int t1 = link.pop();
                int t2 = link.pop();
                if (s[i].equals("*")) {
                    link.push(t1 * t2);
                } else if (s[i].equals("+")) {
                    link.push(t1 + t2);
                }
            }
        }
        System.out.println(link.pop());
    }

}
