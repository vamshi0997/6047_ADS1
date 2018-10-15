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
     * @param args The command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int nStocks = Integer.parseInt(scan.nextLine());
        BinarySearchST<String, Integer> minST
        = new BinarySearchST<String, Integer>(nStocks);
        BinarySearchST<String, Integer> maxST
        = new BinarySearchST<String, Integer>(nStocks);
        for (int i = 0; i < 2 * (2 + 1); i++) {
            MinPQ<Stock> min = new MinPQ<Stock>();
            MaxPQ<Stock> max = new MaxPQ<Stock>();
            for (int j = 0; j < nStocks; j++) {
                String[] input = scan.nextLine().split(",");
                Stock s = new Stock(input[0], Double.parseDouble(input[1]));
                min.insert(s);
                max.insert(s);
            }
            for (int l = 0; l < 2 * 2 + 1; l++) {
                Stock str = max.delMax();
                Integer freq = maxST.get(str.getName());
                if (freq != null) {
                    maxST.put(str.getName(), freq + 1);
                } else {
                    maxST.put(str.getName(), 1);
                }
                System.out.println(str.getName() + " " + str.getChange());
            }
            System.out.println();
            for (int k = 0; k < 2 * 2 + 1; k++) {
                Stock str = min.delMin();
                Integer freq = minST.get(str.getName());
                if (freq != null) {
                    minST.put(str.getName(), freq + 1);
                } else {
                    minST.put(str.getName(), 1);
                }
                System.out.println(str.getName() + " " + str.getChange());
            }
            System.out.println();
        }

        int input = Integer.parseInt(scan.nextLine());
        for (int a = 0; a < input; a++) {
            String[] bstinp = scan.nextLine().split(",");
            if (bstinp[0].equals("get")) {
                if (bstinp[1].equals("minST")) {
                    Integer freq = minST.get(bstinp[2]);
                    if (freq != null) {
                        System.out.println(minST.get(bstinp[2]));
                    } else {
                        System.out.println(0);
                    }
                } else if (bstinp[1].equals("maxST")) {
                    Integer freq = maxST.get(bstinp[2]);
                    if (freq != null) {
                        System.out.println(maxST.get(bstinp[2]));
                    } else {
                        System.out.println(0);
                    }
                }
            }
            if (bstinp[0].equals("intersection")) {
                for (String s: maxST.keys()) {
                    for (String s1: minST.keys()) {
                        if (s.equals(s1)) {
                            System.out.println(s);
                        }
                    }
                }
            }
        }
    }
}
