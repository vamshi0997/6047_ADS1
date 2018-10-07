import java.util.Scanner;
/**
 * Solution class contain main method.
 */
public final class Solution {
    /**
     * default private Constructor for the Solution class.
     */
    private Solution() {
    }
    // /**
    //  * main method handles the input and output.
    //  *
    //  * @param args command line arguments.
    //  */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        QuickSort sort = new QuickSort();
        int testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++) {
            int subarrsize = Integer.parseInt(sc.nextLine());
            String[] line = sc.nextLine().split(" ");
            //String[] tokens = line.split(" ");
            if (line[0].equals("")) {
                System.out.println("[]");
            } else {
                sort.sort(line, subarrsize);
                System.out.println(sort.toString(line));
            }
        }
    }
}
