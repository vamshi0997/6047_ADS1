import java.util.Arrays;
import java.util.Scanner;
/**
 * Solution class contain main method and other methods.
 */
final class Solution {
    /**
     * private solution constructor.
     */
    private Solution() {

    }
    /**
     * main method gives the 3-sum result.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int k = Arrays.binarySearch(arr, -(arr[i] + arr[j]));
                if (k > j) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
