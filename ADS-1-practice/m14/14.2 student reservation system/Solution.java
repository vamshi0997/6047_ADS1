import java.util.Scanner;
/**
 * Solution class contains main method.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {
    }
    /**
     * main method is used to handle input and outputs.
     *
     * @param args commandline arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int qualified = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int unreserved = Integer.parseInt(scan.nextLine());
        int bcvacancies = Integer.parseInt(scan.nextLine());
        int scvacancies = Integer.parseInt(scan.nextLine());
        int stvancancies = Integer.parseInt(scan.nextLine());
        Selection sel = new Selection();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(",");
            Student s = new Student(line[0], line[1],
                Integer.parseInt(line[2]), Integer.parseInt(line[2 + 1]),
                Integer.parseInt(line[2 + 2]), Integer.parseInt(
                    line[2 + 2 + 1]), line[2 + 2 + 2]);
            sel.add(s);
        }
        System.out.println(sel.sort());
        System.out.println();
        System.out.println(sel.sort1(
            vacancies, unreserved, bcvacancies, scvacancies, stvancancies));
    }
}
