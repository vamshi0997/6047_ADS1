import java.util.Scanner;
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
