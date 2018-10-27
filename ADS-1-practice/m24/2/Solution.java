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
    /**
     * Main methods handles the input and output methods.
     *
     * @param      args  The arguments at command line.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        BST<Student, String> bs = new BST<Student, String>();
        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split(",");
            Student s = new Student(
                input[0], input[1], Double.parseDouble(input[2]));
            bs.put(s, input[0]);
        }
        int num1 = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < num1; j++) {
            String[] command = scan.nextLine().split(" ");
            if (command[0].equals("BE")) {
                for (Student s1: bs.keys()) {
                    if (s1.getMarks() >= Double.parseDouble(command[1])
                        && s1.getMarks() <= Double.parseDouble(command[2])) {
                        System.out.println(s1.getName());
                    }
                }

            } else if (command[0].equals("GE")) {
                for (Student s1: bs.keys()) {
                    if (s1.getMarks() <= Double.parseDouble(command[1])) {
                        System.out.println(s1.getName());
                    }
                }
            } else if (command[0].equals("LE")) {
               for (Student s1: bs.keys()) {
                    if (s1.getMarks() >= Double.parseDouble(command[1])) {
                        System.out.println(s1.getName());
                    }
                }
            }
        }
    }
}
