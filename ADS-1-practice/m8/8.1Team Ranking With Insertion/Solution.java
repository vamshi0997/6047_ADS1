import java.util.Scanner;
/**
 * Solution class contains main method.
 */
public final class Solution {
    /**
     * default private constructor to not provide access to others.
     */
    private Solution() {

    }
    /**
     * main method is used to handle input and make use of other classes.
     *
     * @param args commandline arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Teams t1 = new Teams();
        Teams t2 = new Teams();
        SeletionSort s1 = new SeletionSort();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(",");
            Team t = new Team(line[0], Integer.parseInt(line[1]),
                Integer.parseInt(line[2]),
                Integer.parseInt(line[2+1]));
            t1.add(t);
        }
        System.out.println(t1.sort());
    }
}
