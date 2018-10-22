import java.util.Comparator;
import java.util.NoSuchElementException;
/**
 * Class for minimum pq.
 * @param <Key> The key
 */
public class MinPQ<Key> implements Iterable<Key> {
    /**
     * tore items at indices 1 to n.
     */
    private Key[] pq;
    /**
     * number of items on priority queue.
     */
    private int n;
    /**
     * optional comparator.
     */
    private Comparator<Key> comparator;

    /**
     * Time complexity O(1).
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Time complexity O(1).
     * Initializes an empty priority queue.
     */
    public MinPQ() {
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
    public MinPQ(final int initCapacity, final Comparator<Key> comparator1) {
        this.comparator = comparator1;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator1 the order in which to compare the keys
     */
    public MinPQ(final Comparator<Key> comparator1) {
        this(1, comparator1);
    }

    /**
     * Time complexity is O((N/2)logN).
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys,
     * using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public MinPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
    }

    /**
     * Time complexity is O(1).
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Time complexity is O(1).
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Time complexity is O(1).
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    /**
     * Time complexity is O(N).
     * helper function to double the size of the heap array
     * resize method to resize the array.
     * @param capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Time complexity is O(logN).
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }

    /**
     * Time complexity is O(logN).
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 2 + 2)) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }
    /**
     * Time complexity is O(logN).
     * swim method.
     * @param k index.
     */
    private void swim(final int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * Time complexity is O(logN).
     * sink method.
     * @param k index.
     */
    private void sink(final int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * Time complexity is O(1).
     * greater method.
     * @param  i     index.
     * @param  j     index.
     * @return     true or false.
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * Time complexity is O(1).
     * exch method to swap the elements.
     * @param  i     index.
     * @param  j     index.
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}

