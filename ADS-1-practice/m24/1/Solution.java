import java.util.Scanner;
/**
 * Solution class.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        SeparateChainingHashST<String, Student> scht = new SeparateChainingHashST<String, Student>();
        for(int i = 0; i < num; i++) {
        	String[] input = scan.nextLine().split(",");
        	Student s = new Student(input[0], input[1], Double.parseDouble(input[2]));
        	scht.put(input[0], s);
        }
        int num1 = Integer.parseInt(scan.nextLine());
        for(int j = 0; j < num1; j++) {
        	String[] ginput = scan.nextLine().split(" ");
        	Student sd = scht.get(ginput[1]);
        	if(ginput[2].equals("1")) {
        		System.out.println(sd.getName());
        	} else {
        		System.out.println(sd.getMarks());
        	}
        }
	}
}