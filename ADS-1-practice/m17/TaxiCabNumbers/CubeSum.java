import java.util.Scanner;
public class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
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

        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
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
        }

            temp = s.sum;
            if (s.j < n)
                pq.insert(new CubeSum(s.i, s.j + 1));
        }
    }
}