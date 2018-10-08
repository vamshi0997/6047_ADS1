import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MinPQ class contain different methods.
 *  @param <Key> the generic type of key on this priority queue
 */
class MinPQ<Key> implements Iterable<Key> {
    /**
     * store items at indices 1 to n.
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
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param initCapacity the initial capacity of this priority queue.
     */
    MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    MinPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator1 the order in which to compare the keys
     */
    MinPQ(final int initCapacity, final Comparator<Key> comparator1) {
        this.comparator = comparator1;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator1 the order in which to compare the keys
     */
    MinPQ(final Comparator<Key> comparator1) {
        this(1, comparator1);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys,
     * using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    // MinPQ(final Key[] keys) {
    //     n = keys.length;
    //     pq = (Key[]) new Object[keys.length + 1];
    //     for (int i = 0; i < n; i++) {
    //         pq[i + 1] = keys[i];
    //     }
    //     for (int k = n / 2; k >= 1; k--) {
    //         sink(k);
    //     }
    //     assert isMinHeap();
    // }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
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
     * helper function to double the size of the heap array.
     * resizing array.
     *
     * @param capacity array size.
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
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     * @return true or false.
     */
    public boolean insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        //swim(n);
        return isMinHeap();
    }

    /**
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
        //sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / (2 + 2))) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }
    // /**
    //  * swim function is checks parent elment with child element.
    //  *
    //  * @param k given element position.
    //  */
    // private void swim(int k) {
    //     while (k > 1 && greater(k / 2, k)) {
    //         exch(k, k / 2);
    //         k = k / 2;
    //     }
    // }
    // /**
    //  * sink function is used to check given element.
    //  *
    //  * @param k given element position.
    //  */
    // private void sink(int k) {
    //     while (2 * k <= n) {
    //         int j = 2 * k;
    //         if (j < n && greater(j, j + 1)) {
    //             j++;
    //         }
    //         if (!greater(k, j)) {
    //             break;
    //         }
    //         exch(k, j);
    //         k = j;
    //     }
    // }

    /**
     * greater funtion gives which is greater.
     *
     * @param i first element.
     * @param j second element.
     *
     * @return true or false which is greater.
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {

            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    /**
     * exchange method.
     *
     * @param i first element.
     * @param j second element.
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     * is pq[1..N] a min heap.
     * @return true or flase base on min heap.
     */
    public boolean isMinHeap() {
        return isMinHeap(1);
    }

    /**
     * is subtree of pq[1..n] rooted at k a min heap.
     *
     * @param k integer value.
     * @return true or flase base on min heap.
     */
    private boolean isMinHeap(final int k) {
        //System.out.println(k);
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left)) {
            return false;
        }
        if (right <= n && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }


    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in ascending order.
     * <p>
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }
    /**
     * HeapIterator class.
     */
    private class HeapIterator implements Iterator<Key> {
        /**
         * create a new pq.
         */
        private MinPQ<Key> copy;
        /**
         * add all items to copy of heap.
         * takes linear time since already in heap order so no keys move
         */
        HeapIterator() {
            if (comparator == null) {
                copy = new MinPQ<Key>(size());
            } else {
                copy = new MinPQ<Key>(size(), comparator);
            }
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }
        /**
         * It takes the hasnext method.
         * @return ture are false.
         */
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        /**
         * to remove.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * @return each element in the MinPQ.
         */
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }

}

/**
 * Solution class contain main method and other static methods.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * main method is used to handle input cases.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
            int testcase = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < testcase; i++) {
                int flag = 0;
                if (str.equals("String") || str.equals("Double")) {
                    String tmp = scan.nextLine();
                    String[] str1 = tmp.split(",");

                    MinPQ<String> m = new MinPQ<String>();
                    for (String s: str1) {
                        if (!m.insert(s)) {
                            System.out.println("false");
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println(true);
                    }
                } else if (str.equals("Integer")) {
                    String tmp = scan.nextLine();
                    String[] str1 = tmp.split(",");
                    MinPQ<Integer> m = new MinPQ<Integer>();
                    for (String s: str1) {
                        if (!m.insert(Integer.parseInt(s))) {
                            System.out.println("false");
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println(true);
                    }
                } else if (str.equals("Float")) {
                    String tmp = scan.nextLine();
                    if (tmp.length() == 0) {
                        System.out.println("false");
                        return;
                    }
                    String[] str1 = tmp.split(",");
                    MinPQ<Float> m = new MinPQ<Float>();
                    for (String s: str1) {
                        if (!m.insert(Float.parseFloat(s))) {
                            System.out.println("false");
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println(true);
                    }
                }
            }
    }
}

