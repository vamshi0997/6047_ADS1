/**
 *  The {@code SeparateChainingHashST}
 *  class represents a symbol table of generic
 *  key-value pairs.
 *  @param <Key> The Key.
 *  @param <Value> The Value.
 */
public class SeparateChainingHashST<Key, Value> {
    /**
     * initial capacity.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs.
     */
    private int n;
    /**
     * hash table size.
     */
    private int m;
    /**
     * array of linked-list symbol tables.
     */
    private SequentialSearchST<Key, Value>[] st;

    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Time complexity is O(N).
     * Initializes an empty symbol table with {@code m} chains.
     * @param m1 the initial number of chains
     */
    public SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m1; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    /**
     * Time complexity is O(1).
     * hash value between 0 and m-1.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key) {
        final int hex = 0x7fffffff;
        return (key.hashCode() & hex) % m;
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
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
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
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * Time complexity is O(N).
     * Inserts the specified key-value pair into the symbol table,
     * overwriting the old
     * value with the new value if the symbol table
     * already contains the specified key.
     * Deletes the specified key (and its associated value)
     * from this symbol table
     * if the specified value is {@code null}.
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

        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }
}
