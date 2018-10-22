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
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BST<Book, Integer> bst = new BST<Book, Integer>();
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(",");
            switch (input[0]) {
                case "put":
                Book bk = new Book(
                input[1], input[2], Float.parseFloat(input[2 + 1]));
                bst.put(bk, Integer.parseInt(input[2 + 2]));
                break;
                case "get":
                Book bk1 = new Book(
                input[1], input[2], Float.parseFloat(input[2 + 1]));
                System.out.println(bst.get(bk1));
                break;
                case "min":
                System.out.println(bst.min());
                break;
                case "max":
                System.out.println(bst.max());
                break;
                case "floor":
                Book bk2 = new Book(
                input[1], input[2], Float.parseFloat(input[2 + 1]));
                System.out.println(bst.floor(bk2));
                break;
                case "ceiling":
                Book bk3 = new Book(
                input[1], input[2], Float.parseFloat(input[2 + 1]));
                System.out.println(bst.ceiling(bk3));
                break;
                case "select":
                System.out.println(bst.select(Integer.parseInt(input[1])));
                break;
                default:
                break;
            }

        }
    }
 }
 