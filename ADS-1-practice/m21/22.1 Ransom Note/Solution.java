import java.util.Scanner;
import java.util.Hashtable;
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
        Hashtable<String, Integer> m = new Hashtable<String, Integer>();
        Hashtable<String, Integer> m1 = new Hashtable<String, Integer>();
        String input[] = scan.nextLine().split(" ");
        String[] magazine = scan.nextLine().split(" ");
        String[] note = scan.nextLine().split(" ");
        for(int i = 0; i < magazine.length; i++) {
            Integer count = m.get(magazine[i]);
            if (m.containsKey(magazine[i])) {
                m.put(magazine[i], count + 1);
            } else {
                m.put(magazine[i], 1);
            }
        }

        for(int j = 0; j < note.length; j++) {
            if (!m.containsKey(note[j])) {
                System.out.println("No");
                return;
            }
            else if (m.containsKey(note[j])) {
                Integer num = m1.get(note[j]);
                if(m1.containsKey(note[j])) {
                    m1.put(note[j], num + 1);
                } else {
                    m1.put(note[j], 1);
                }
                if (m1.get(note[j]) > m.get(note[j])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}