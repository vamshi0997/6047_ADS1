import java.util.Iterator;
/**
 * Queue class.
 * @param      <Item>  The item
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * first of type Node.
     */
    private Node<Item> first;
    /**
     * second of type Node.
     */
    private Node<Item> last;
    /**
     * size.
     */
    private int n;
    /**
     * Class for node.
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * item of type Item.
         */
        private Item item;
        /**
         * next of type Node.
         */
        private Node<Item> next;
    }
    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    /**
     * Returns true if this queue is empty.
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }
    /**
     * Adds the item to this queue.
     * @param  item the item to add
     */
    public void enqueue(final Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }
    /**
     * iterator method.
     * @return     Iterator.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    /**
     * Class for list iterator.
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * current of type Node.
         */
        private Node<Item> current;
        /**
         * Constructs the object.
         * @param      f  The first
         */
        ListIterator(final Node<Item> f) {
            current = f;
        }
        /**
         * Determines if it has next.
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * next method that returns the elements.
         *
         * @return     item.
         */
        public Item next() {
            if (!hasNext()) {
                return null;
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
