import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST<Book, Integer> bst = new BST<Book, Integer>();
        while (scan.hasNext()) {
        	String[] input = scan.nextLine().split(",");
        	Book b = new Book(input[1], input[2], Float.parseFloat(input[3]));
        	switch(input[0]) {
        		case "put":
                bst.put(b, Integer.parseInt(input[4]));
                break;
                case "get":
                //Book b1 = new Book(input[1], input[2], Float.parseFloat(input[3]));
                System.out.println( bst.get(b));
                break;
        	}

        }
	}
 }