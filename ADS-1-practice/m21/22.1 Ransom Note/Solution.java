import java.util.Scanner;
import java.util.HashSet;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
    private Solution() {

    }
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        HashSet<String> m = new HashSet<String>();
        HashSet<String> m1 = new HashSet<String>();
        // int a = Integer.parseInt(scan.nextLine());
        // int b = Integer.parseInt(scan.nextLine());
        String input[] = scan.nextLine().split(" ");
        String[] magazine = scan.nextLine().split(" ");
        String[] note = scan.nextLine().split(" ");
        for(int i = 0; i < magazine.length; i++) {
            m.add(magazine[i]);
        }
        for(int j = 0; j < note.length; j++) {
            if (!m.contains(note[j])) {
                System.out.println("No");
                return;
            } else if (m.contains(note[j]) && m1.contains(note[j])) {
                System.out.println("No");
                return;
            } else if(m.contains(note[j])) {
                m1.add(note[j]);
            }
        }
        System.out.println("Yes");
    }
}