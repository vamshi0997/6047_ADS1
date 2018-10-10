/**
 * Class for binary search st.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * keys array of type Key.
     */
    private Key[] keys;
    /**
     * values array of type Value.
     */
    private Value[] values;
    /**
     * size of type int.
     */
    private int size = 0;
    /**
     * Constructs the object.
     * @param      size1  The size
     */
    BinarySearchST(final int size1) {
        keys = (Key[]) new Comparable[size1];
        values = (Value[]) new Object[size1];
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * delete method to delete the key.
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            return;
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < size - 1; j++)  {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[size] = null;
        values[size] = null;
    }
    /**
     * put method which inserts the elements into queue.
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Value value) {
        if (key == null) {
            return;
        }
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }
    /**
     * contains method that checks whether the key is.
     * present or not.
     * @param      key   The key
     * @return     true or false.
     */
    public boolean contains(final Key key) {
        if (key == null) {
            return false;
        }
        return get(key) != null;
    }
    /**
     * get method that gets the value of key.
     * @param      key   The key
     * @return     value of specific key.
     */
    public Value get(final Key key) {
        if (key == null) {
            return null;
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * max method.
     * @return     key.
     */
    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return keys[size - 1];
    }
    /**
     * min method.
     * @return     key.
     */
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return keys[0];
    }
    /**
     * floor method.
     * @param      key   The key
     * @return     key.
     */
    public Key floor(final Key key) {
        if (key == null) {
            return null;
        }
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }
    /**
     * rank method.
     * @param      key   The key
     * @return     rank of type int.
     */
    public int rank(final Key key) {
        if (key == null) {
            return 0;
        }
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /**
     * deleteMin method that deletes minimum key.
     */
    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        delete(min());
    }
    /**
     * keys method which displays the keys.
     * @return     keys of type Iterable.
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
    /**
     * keys method which displays the keys.
     * @param      lo    The lower
     * @param      hi    The higher
     * @return     keys of type Iterable.
     */
    public Iterable<Key> keys(final Key lo, final Key hi) {
        if (lo == null || hi == null) {
            return null;
        }
        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) {
            return queue;
        }
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }
}
