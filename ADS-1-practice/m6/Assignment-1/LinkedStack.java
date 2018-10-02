import java.util.Scanner;

/**
 * LinkedStack contain pop and push methods.
 * @param <E> generic maode.
 */
class LinkedStack<E> {
    /**
     * Node first always points to top node in list.
     */
    private Node<E> first = null;
    int size = 0;
    /**
     * class node creates a new node each time.
     * @param <E> for generic.
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
     * @param item element to push.
     */
    public void push(final E item) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    /**
     * pop method is to remove the item.
     * @return the poped element.
     */
    public E pop() {
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }
    /**
     * Gives the top node.
     * @return first or top Node.
     */
    public Node<E> getFirst() {
        return first;
    }
    public String display() {
        return null;
    }
}