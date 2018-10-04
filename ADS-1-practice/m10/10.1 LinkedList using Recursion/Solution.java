import java.util.Scanner;
/**
 * Solution class contain main method and other methods.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * main method for handling input.
     * @param args commandLine arguments.
     */
    public static void main(final String[] args) {
        LinkedList list = new LinkedList();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            switch(line[0]) {
            case "insertAt":
                try {
                    list.insert(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                    list.print();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "reverse":
                try {
                    list.reverse();
                    list.print();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                break;
            }
        }
    }
}
