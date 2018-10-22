import java.util.Scanner;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * MinPQ class contain different methods.
 *  @param <Key> the generic type of key on this priority queue
 */
class MinPQ<Key> {
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
     * Time complexity is O(1).
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param initCapacity the initial capacity of this priority queue.
     */
    MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Time complexity is O(1).
     * Initializes an empty priority queue.
     */
    MinPQ() {
        this(1);
    }

    /**
     * Time complexity is O(1).
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
     * Time complexity is O(1).
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator1 the order in which to compare the keys
     */
    MinPQ(final Comparator<Key> comparator1) {
        this(1, comparator1);
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
     * Time complexity is O(N).
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
     * Time complexity is O(1).
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
     * Time complexity is O(logN)
     * is pq[1..N] a min heap.
     * @return true or flase base on min heap.
     */
    public boolean isMinHeap() {
        return isMinHeap(1);
    }

    /**
     * Time complexity is O(logN).
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

