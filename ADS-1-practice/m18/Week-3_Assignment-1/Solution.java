import java.util.Scanner;
/**
 * Solution class contain main method.
 */
public final class Solution {
	/**
	 * Constructs the object for solution.
	 */
	private Solution() {

	}
	/**
	 * main method is used to handle the inputs.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int nStocks = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < 6; i++) {
        	MinPQ<Stock> min = new MinPQ<Stock>();
        	MaxPQ<Stock> max = new MaxPQ<Stock>();
            for(int j = 0; j < nStocks; j++) {
        	    String[] input = scan.nextLine().split(",");
        	    Stock s = new Stock(input[0], Double.parseDouble(input[1]));
        	    min.insert(s);
        	    max.insert(s);
            }
            for(int k = 0; k < 5; k++) {
            	System.out.println(min.delMin().tostr());
            }
            System.out.println();
            for(int l = 0; l < 5; l++) {
            	System.out.println(max.delMax().tostr());
            }

        }

	}
}