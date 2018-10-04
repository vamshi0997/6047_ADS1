import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
	LinkedList list = new LinkedList();
    Scanner scan = new Scanner(System.in);
    while (scan.hasNext()) {
    	String[] line = scan.nextLine().split(" ");
    	switch (line[0]) {
    		case "insertAt":
            //System.out.println(list.size);
            if (Integer.parseInt(line[1]) <= list.size && Integer.parseInt(line[1]) >= 0) {
                list.insert(line[2], Integer.parseInt(line[1]));
                list.print();
            } else {
                list.insert(line[2], Integer.parseInt(line[1]));
            }
    		break;
    		case "reverse":
            list.reverse();
    		break;
    		default:
    		break;
    	} 
    }
	}
}