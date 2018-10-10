import java.util.Scanner;
/**
 * Solution class contain main method.
 */
public final class Solution {
    /**
     * default constructor for solution class.
     */
    private Solution() {

    }
    /**
     * main method is used to handle input and acessing other classes.
     * Here we access the binarysearch symbol table.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        BinarySearchST<String, Integer> bs = new BinarySearchST
        <String, Integer>(array.length);
        for (int i = 0; i < array.length; i++) {
            bs.put(array[i], i);
        }
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]) {
                case "max":
                System.out.println(bs.max());
                break;
                case "floor":
                System.out.println(bs.floor(input[1]));
                break;
                case "rank":
                System.out.println(bs.rank(input[1]));
                break;
                case "deleteMin":
                bs.deleteMin();
                break;
                case "contains":
                System.out.println(bs.contains(input[1]));
                break;
                case "keys":
                for (String s: bs.keys()) {
                    System.out.println(s);
                }
                break;
                case "get":
                System.out.println(bs.get(input[1]));
                break;
                default:
                break;
            }
        }
    }
}
