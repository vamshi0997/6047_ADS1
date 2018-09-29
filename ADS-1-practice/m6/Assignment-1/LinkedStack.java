import java.util.Scanner;
//import java.util.Arrays;

/**
 * LinkedStack contain pop and push methods.
 */
class LinkedStack {
    /**
     * Node first always points to top node in list.
     */
    private Node first = null;
    /**
     * class node creates a new node each time.
     */
    class Node {
        /**
         * String item name.
         */
        private String item;
        /**
         * Node next.
         */
        private Node next;
        /**
         * returns the node name.
         * @return node.
         */
        public String getName() {
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
     * @param item element to push.
     */
    public void push(final String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    /**
     * pop method is to remove the item.
     * @return the poped element.
     */
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
    /**
     * Gives the top node.
     * @return first or top Node.
     */
    public Node getFirst() {
        return first;
    }
}
