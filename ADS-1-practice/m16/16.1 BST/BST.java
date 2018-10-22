/**
 *  The {@code BST} class represents an ordered symbol table of generic
 *  key-value pairs.
 *  @param <Key> the key.
 *  @param <Value> the value.
 */
public class BST<Key extends Comparable<Key>, Value> {
    /**
     * root of node type.
     */
    private Node root;
    /**
     * class Node.
     */
    private class Node {
        /**
         * key of key type.
         */
        private Key key;
        /**
         * value of value type.
         */
        private Value val;
        /**
         * left and right of Node type.
         */
        private Node left, right;
        /**
         * size of int type.
         */
        private int size;
        /**
         * Node constructor.
         *
         * @param key1 The key.
         * @param val1 The value.
         * @param size1 The size.
         */
        Node(final Key key1, final Value val1, final int size1) {
            this.key = key1;
            this.val = val1;
            this.size = size1;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {
    }

    /**
     * Time complexity is O(1).
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    /**
     * Time complexity is O(1).
     * return number of key-value pairs in BST rooted at x.
     *
     * @param x the Node.
     * @return size.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }

    /**
     * Time complexity is O(N).
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given
     * key if the key is in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final Key key) {
        return get(root, key);
    }

    /**
     * Time complexity is O(N).
     * get method return the value of given key.
     *
     * @param x The Node.
     * @param key The key.
     *
     * @return The value.
     */
    private Value get(final Node x, final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    /**
     * Time complexity is O(N).
     * Inserts the specified key-value pair into the symbol table,
     * overwriting the old
     * value with the new value
     * if the symbol table already contains the specified key.
     * Deletes the specified key
     * (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with a null key");
        }
        root = put(root, key, val);
    }
    /**
     * Time complexity is O(N).
     * Inserts the specified key-value pair into the symbol table,
     * overwriting the old
     * value with the new value
     * if the symbol table already contains the specified key.
     * Deletes the specified key
     * (and its associated value) from this symbol table.
     * @param x The Node.
     * @param key The key.
     * @param val The value.
     * @return The Node.
     */
    private Node put(final Node x, final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val   = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
}
