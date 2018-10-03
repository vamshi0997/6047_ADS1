import java.util.Scanner;
/**
 * Solution class contain main method.
 */
public final class Solution {
	/**
	 * default private constructor.
	 */
	private Solution() {

	}
	/**
	 * main method is used to hand input strings.
	 */
	public static void main(final String[] args) {
		MergeSort m = new MergeSort();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String[] line = scan.nextLine().split(",");
            m.sort(line);
            System.out.println(m.show(line));
            System.out.println();
        }
	}
}