import java.util.Comparator;
/**
 * Class for maximum pq.
 * @param      <Key>  The key
 */
public class MaxPQ<Key> {
    /**
     *  key variable.
     */
    private Key[] pq;
    /**
     * n variable.
     */
    private int n;
    /**
     * comparator variable.
     */
    private Comparator<Key> comparator;

    /**
     * Time complexity O(1).
     * Initializes an empty priority queue with the given initial capacity.
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MaxPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Time complexity O(1).
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }
    /**
     * Time complexity O(1).
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator1 the order in which to compare the keys
     */
    public MaxPQ(final int initCapacity,
        final Comparator<Key> comparator1) {
        this.comparator = comparator1;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator1 the order in which to compare the keys
     */
    public MaxPQ(final Comparator<Key> comparator1) {
        this(1, comparator1);
    }

    /**
     * Time complexity is O((N/2)logN).
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys,
     * using sink-based heap construction.
     * @param  keys the array of keys
     */
    public MaxPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
    }
    /**
     * Time complexity is O(1).
     * Returns true if this priority queue is empty.
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * Time complexity is O(1).
     * Returns the number of keys on this priority queue.
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Time complexity is O(1).
     * Returns a largest key on this priority queue.
     * @return a largest key on this priority queue
     */
    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return pq[1];
    }
    // helper function to double the size of the heap array
    /**
     * Time complexity is O(N).
     * @param capacity value.
     */
    private void resize(final int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * Time complexity is O(logN).
     * Adds a new key to this priority queue.
     * @param  x the new key to add to this priority queue
     */
    public void insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }
    /**
     * Time complexity is O(logN).
     * Removes and returns a largest key on this priority queue.
     * @return a largest key on this priority queue
     */
    public Key delMax() {
        if (isEmpty()) {
            return null;
        }
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 2 + 2)) {
            resize(pq.length / 2);
        }
        return max;
    }
    /**
     * Time complexity is O(logN).
     * swim method.
     * @param      k     index.
     */
    private void swim(final int k) {
        int k1 = k;
        while (k1 > 1 && less(k1 / 2, k1)) {
            exch(k1, k1 / 2);
            k1 = k1 / 2;
        }
    }
    /**
     * Time complexity is O(logN).
     * sink method.
     * @param k index.
     */
    private void sink(final int k) {
        int k1 = k;
        while (2 * k1 <= n) {
            int j = 2 * k1;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k1, j)) {
                break;
            }
            exch(k1, j);
            k1 = j;
        }
    }
    /**
     * Time complexity is O(1).
     * less method.
     * @param      i     index.
     * @param      j     index.
     * @return     true or false.
     */
    private boolean less(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }
    /**
     * Time complexiy is O(1).
     * exch method to swap the elements of array.
     * @param      i     index.
     * @param      j     index.
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * Time complexiy is O(N).
     * Determines if maximum heap.
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }
    /**
     * Time complexiy is O(N).
     * Determines if maximum heap.
     * @param k index.
     * @return True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap(final int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && less(k, left))  {
            return false;
        }
        if (right <= n && less(k, right)) {
            return false;
        }
        return isMaxHeap(left) && isMaxHeap(right);
    }
}
