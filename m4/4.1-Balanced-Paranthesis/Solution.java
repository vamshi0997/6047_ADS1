import java.util.Scanner;
import java.util.Arrays;

class LinkedStack {
	private Node first = null;
	class Node {
        String item;
        Node next;
        public String getName() {
        	return this.item;
        }
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}

	public Node getFirst() {
        return first;
	}


}

public final class Solution {
	public static void main (String[] args) {
		LinkedStack link = new LinkedStack();
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        while(scan.hasNext()) {
        	int flag = 0;
        	String[] str = scan.nextLine().split("");
        	//System.out.println(Arrays.toString(str));
        	for (int i = 0; i < str.length; i++) {
                if (str[i].equals("[") || str[i].equals("{") || str[i].equals("(")) {
                	link.push(str[i]);
                } else if (str[i].equals("]")) {
                	if (link.isEmpty()) {
                		//System.out.println("NO");
                		flag = 1;
                		break;
                	}
                	if (link.getFirst().getName().equals("[")) {
                		link.pop();
                	}
                } else if (str[i].equals("}")) {
                	if (link.isEmpty()) {
                        //System.out.println("NO");
                        flag = 1;
                        break;
                	}
                	if (link.getFirst().getName().equals("{")) {
                		link.pop();
                	}
                } else if (str[i].equals(")")) {
                	if (link.isEmpty()) {
                		//System.out.println("NO");
                		flag = 1;
                		break;
                	}
                	if (link.getFirst().getName().equals("(")) {
                		link.pop();
                	}
                }
        	}
        	if (flag == 1) {
                System.out.println("NO");
        	} else {
                if (link.isEmpty()) {
                	System.out.println("YES");
                } else {
                	System.out.println("NO");
                }
        	}
        }
	}
}