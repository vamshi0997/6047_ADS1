import java.util.Scanner;
//import java.util.Hashtable;
/**
 * Class for solution1.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Time complexity is O(N).
     * Main method handles the input and outputs and access other classes.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> table4Magazine =
        new SeparateChainingHashST<String, Integer>();
        SeparateChainingHashST<String, Integer> table4Note =
        new SeparateChainingHashST<String, Integer>();

        String[] input = scan.nextLine().split(" ");
        String[] magazine = scan.nextLine().split(" ");
        String[] note = scan.nextLine().split(" ");

        for (int i = 0; i < magazine.length; i++) {
            Integer count = table4Magazine.get(magazine[i]);
            if (table4Magazine.contains(magazine[i])) {
                table4Magazine.put(magazine[i], count + 1);
            } else {
                table4Magazine.put(magazine[i], 1);
            }
        }

        for (int j = 0; j < note.length; j++) {
            if (!table4Magazine.contains(note[j])) {
                System.out.println("No");
                return;
            }
            if (table4Magazine.contains(note[j])) {
                Integer num = table4Note.get(note[j]);
                if (table4Note.contains(note[j])) {
                    table4Note.put(note[j], num + 1);
                } else {
                    table4Note.put(note[j], 1);
                }
                if (table4Note.get(note[j]) > table4Magazine.get(note[j])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
