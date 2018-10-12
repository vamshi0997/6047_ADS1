import java.util.Scanner;
public class Solution implements Comparable<Solution> {
    private final int sum;
    private final int i;
    private final int j;

    public Solution(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(Solution that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }

    public static void main(String[] args) {
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
            //     count++;
            // } else {
            //     count = 0;
            // }
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
            if (s.j < n)
                pq.insert(new Solution(s.i, s.j + 1));
        }
    }
}
