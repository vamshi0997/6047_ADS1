/**
 *  The {@code SequentialSearchST} class represents an (unordered)
 *  symbol table of generic key-value pairs.
 *  @param <Key> The Key.
 *  @param <Value> The Value.
 */
public class SequentialSearchST<Key, Value> {
    /**
     * number of key-value pairs.
     */
    private int n;
    /**
     * number of key-value pairs.
     */
    private Node first;
    /**
     * a helper linked list data type.
     * Class for node.
     */
    private class Node {
        /**
         * key of node.
         */
        private Key key;
        /**
         * value of node.
         */
        private Value val;
        /**
         * next of node type.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      key1    The key
         * @param      val1    The value
         * @param      next1  The next 1
         */
        Node(final Key key1, final Value val1, final Node next1)  {
            this.key  = key1;
            this.val  = val1;
            this.next = next1;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {
    }

    /**
     * Time complexity is O(1).
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     * Time complexity is O(N).
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * Time complexity is O(N).
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key
     * if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to get() is null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    /**
     * Time complexity is O(1).
     * Inserts the specified key-value
     * pair into the symbol table, overwriting the old
     * value with the new value if the symbol table
     * already contains the specified key.
     * Deletes the specified key.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
}
