import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for merge where two elements are sorted.
 */
class Merge {
    /**
     * Time complexity is O(logN).
     * sorting two arrays into a single array.
     * @param firstarr int array
     * @param secondarr int array
     */
    public static void mergesort(final int[] firstarr, final int[] secondarr) {
        int i = 0;
        int j = 0;
        int[] result;
        result = new int[firstarr.length + secondarr.length];
        for (int k = 0; k < result.length; k++) {
            if (i < firstarr.length && j < secondarr.length) {
                if (firstarr[i] < secondarr[j]) {
                    result[k] = firstarr[i++];
                } else {
                    result[k] = secondarr[j++];
                }
            } else if (i >= firstarr.length) {
                result[k] = secondarr[j++];
            } else if (j >= secondarr.length) {
                result[k] = firstarr[i++];
            }
        }
        System.out.println(
            Arrays.toString(result).replace(
                "[", "").replace("]", "").replace(" ", ""));
    }
}

/**
 * In solution class we have main method and other methods.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * main function where we initialize the two arrays.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Merge m = new Merge();
        int size1 = Integer.parseInt(scan.nextLine());
        int size2 = Integer.parseInt(scan.nextLine());
        String[] first = scan.nextLine().split(",");
        String[] second = scan.nextLine().split(",");
        int[] firstarr;
        int[] secondarr;
        secondarr = new int[second.length];

        if (first[0].equals("")) {
            firstarr = new int[0];
        } else {
            firstarr = new int[first.length];
            for (int i = 0; i < first.length; i++) {
            firstarr[i] = Integer.parseInt(first[i]);
        }

        }
        for (int i = 0; i < second.length; i++) {
            secondarr[i] = Integer.parseInt(second[i]);
        }

        m.mergesort(firstarr, secondarr);

    }
}
