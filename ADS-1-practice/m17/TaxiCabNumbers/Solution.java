import java.util.Scanner;
/**
 * Solution class contain main method and
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
     * parameterized Solution constructor.
     *
     * @param first1 The first
     * @param second1 The second.
     */
    public Solution(int first1, int second1) {
        this.sum = first1 * first1 * first1 + second1 * second1 * second1;
        this.first = first1;
        this.second = second1;
    }
    /**
     * CompareTo method compares first and second sum.
     *
     * @param that That object.
     * @return integer.
     */
    public int compareTo(Solution that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
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
     * Main method is used to handle the input.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        int n = 600, temp = -1, count = 0;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        MinPQ<Solution> pq = new MinPQ<Solution>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new Solution(i, i));
        }

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            Solution s = pq.delMin();
            if (temp == s.sum) {
                if (++count == M - 1) {
                    N--;
                    if (N == 0) {
                        System.out.println(s.sum);
                        break;
                    }
                }
            } else {
                count = 0;
            }

            temp = s.sum;
            if (s.second < n)
                pq.insert(new Solution(s.first, s.second + 1));
        }
    }
}
