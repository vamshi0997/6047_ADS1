/**
 * ListedList class containing insert and reverse method.
 */
class LinkedList {
    /**
     * head is of type Node.
     */
    private Node head;
    /**
     * tail is type Node.
     */
    private Node tail;
    /**
     * size integer.
     */
    private int size;
    /**
     * Class for node contains data and next.
     */
    class Node {
        int data;
        Node next;
        /**
         * Constructor for node object.
         *
         * @param data1 The data.
         */
        Node(final int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    /**
     * Constructs the object.
     */
    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Time complexity is O(N).
     * Insert method is used to insert,
     * the element at the given position.
     *
     * @param      current   The current
     * @param      temp      The temporary
     * @param      position  The position
     * @param      nPos      The position
     *
     * @return  Node that is inserted.
     */
    private Node insert(
        final Node current, final Node temp,
        final int position, int nPos) {
        if (current == null) {
            return temp;
        } else if (nPos == position) {
            temp.next = current;
            return temp;
        }
        nPos++;
        current.next = insert(current.next, temp, position, nPos);
        return current;
    }
    /**
     * Time complexity is O(N).
     *
     * @param position The position where element is to be inserted.
     * @param data The data in linked list.
     *
     * @throws Exception positon out of bounds exception.
     */
    public void insert(final int position, final int data) throws Exception {

        if (position < 0 || position > size) {
            throw new Exception("Can't insert at this position.");
        }

        head = insert(head, new Node(data), position, 0);
        size++;

    }
    /**
     * Time complexity is O(N).
     * print method prints the total elements in an array.
     */
    public void print() {
        Node current = head;
        String result = "";
        while (current != null) {
            if (current.next == null) {
                result += current.data;
            } else {
                result += current.data + ", ";
            }
            current = current.next;
        }

        System.out.println(result);
    }
    /**
     * Time complexity is O(N).
     *
     * @param current The current node of linked list.
     * @param previous  The previous node of linkedlist.
     *
     * @return Node.
     */
    private Node reverse(final Node current, final Node previous) {
        if (current.next == null) {
            head = current;
            head.next = previous;
            return null;
        }

        Node temp = current.next;
        current.next = previous;

        reverse(temp, current);
        return head;
    }
    /**
     * Time complexity is O(N).
     * reverse method reverse the given linked list.
     *
     * @throws     Exception  Nullexception.
     */
    public void reverse() throws Exception {
        if (head == null) {
            throw new Exception("No elements to reverse.");
        }
        reverse(head, null);
    }
}
