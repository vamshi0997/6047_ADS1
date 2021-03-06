import java.util.Scanner;
/**
 * Solution class contain main method and.
 * other methods such as compareTo etc..,
 */
public class Solution implements Comparable<Solution> {
    /**
     * sum is of min type.
     */
    private final int sum;
    /**
     * first is of int type.
     */
    private final int first;
    /**
     * second is of int type.
     */
    private final int second;
    /**
     * Time complexity O(1).
     * parameterized Solution constructor.
     *
     * @param first1 The first
     * @param second1 The second.
     */
    public Solution(final int first1, final int second1) {
        this.sum = first1 * first1 * first1 + second1 * second1 * second1;
        this.first = first1;
        this.second = second1;
    }
    /**
     * Time complexity is O(1).
     * CompareTo method compares first and second sum.
     *
     * @param that That object.
     * @return integer.
     */
    public int compareTo(final Solution that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Print the value in required string format.
     * @return String.
     */
    public String toString() {
        return sum + " = " + first + "^3" + " + " + second + "^3";
    }
    /**
     * Time complexity is O(2N)
     * Main method is used to handle the input.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        final int sixhundred = 600;
        int number = sixhundred, temp = -1, count = 0;
        Scanner scan = new Scanner(System.in);
        int nthelement = scan.nextInt();
        int mpairs = scan.nextInt();

        MinPQ<Solution> pq = new MinPQ<Solution>();
        for (int i = 0; i <= number; i++) {
            pq.insert(new Solution(i, i));
        }

        while (!pq.isEmpty()) {
            Solution cubesum = pq.delMin();
            if (temp == cubesum.sum) {
                if (++count == mpairs - 1) {
                    nthelement--;
                    if (nthelement == 0) {
                        System.out.println(cubesum.sum);
                        break;
                    }
                }
            } else {
                count = 0;
            }

            temp = cubesum.sum;
            if (cubesum.second < number) {
                pq.insert(new Solution(cubesum.first, cubesum.second + 1));
            }
        }
    }
}
