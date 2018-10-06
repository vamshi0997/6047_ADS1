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
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int Qualified = Integer.parseInt(scan.nextLine());
		int vacancies = Integer.parseInt(scan.nextLine());
		int unreserved = Integer.parseInt(scan.nextLine());
		int bcvacancies = Integer.parseInt(scan.nextLine());
		int scvacancies = Integer.parseInt(scan.nextLine());
		int stvancancies = Integer.parseInt(scan.nextLine());
		Selection sel = new Selection();
		while (scan.hasNext()) {
			String[] line = scan.nextLine().split(",");
			Student s = new Student(line[0], line[1],
				Integer.parseInt(line[2]), Integer.parseInt(line[3]),
				Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6]);
            sel.add(s);
		}
		System.out.println(sel.sort());
	}
}