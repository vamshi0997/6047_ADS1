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
        ThreeSum three = new ThreeSum();
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        //three.sum(arr, size);
        System.out.println(three.sum(arr, size));
    }
}
