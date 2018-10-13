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
        String str2 = "";
        BinarySearchST<String, Integer> bsst = new BinarySearchST<String, Integer>();
        for (int i = 0; i < 6; i++) {
        	MinPQ<Stock> min = new MinPQ<Stock>();
        	MaxPQ<Stock> max = new MaxPQ<Stock>();
            for (int j = 0; j < nStocks; j++) {
        	    String[] input = scan.nextLine().split(",");
        	    Stock s = new Stock(input[0], Double.parseDouble(input[1]));
        	    min.insert(s);
        	    max.insert(s);
            }
            for (int k = 0; k < 5; k++) {
            	String str = min.delMin().tostr();
            	String[] str1 =str.split(" ");
            	str2 +=  str;

                //String strFind = "Java";
                int count = 0, fromIndex = 0;
        
                while ((fromIndex = str2.indexOf(str1[0], fromIndex)) != -1 ){
 
                 //System.out.println("Found at index: " + fromIndex);
                 count++;
                 fromIndex++;
                }
                //System.out.println(count);
            	bsst.put(str1[0], count);
            	System.out.println(str);
            }
            System.out.println();
            for (int l = 0; l < 5; l++) {
            	System.out.println(max.delMax().tostr());
            }
            System.out.println();
        }
        int input = Integer.parseInt(scan.nextLine());
        for (int a = 0; a < input; a++) {
        	String[] bstinp = scan.nextLine().split(",");
        	if (bstinp[0].equals("get")) {
                if(bstinp[1].equals("minST")) {
                	//System.out.println(bsst.get());
                	//System.out.println(bstinp[2]);
        	    }
            }
        }
    }
}