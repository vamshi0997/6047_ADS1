import java.util.Scanner;
/**
 * Solution class contain main method.
 */
public final class Solution {
    /**
     * private default constructor.
     */
    private Solution() {

    }
    /**
     * main method is used to handle input and other output.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST<Book, Integer> bst = new BST<Book, Integer>();
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(",");
            Book bk = new Book(input[1], input[2], Float.parseFloat(input[3]));
            switch(input[0]) {
                case "put":
                bst.put(bk, Integer.parseInt(input[4]));
                break;
                case "get":
                System.out.println( bst.get(bk));
                break;
                default:
                break;
            }

        }
    }
 }
