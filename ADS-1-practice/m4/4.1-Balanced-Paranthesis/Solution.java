import java.util.Scanner;
//import java.util.Arrays;

/**
 * LinkedStack contain pop and push methods.
 */
class LinkedStack {
    /**
     * Node first always points to top node in list.
     */
    private Node first = null;
    /**
     * class node creates a new node each time.
     */
    class Node {
        /**
         * String item name.
         */
        private String item;
        /**
         * Node next.
         */
        private Node next;
        /**
         * returns the node name.
         * @return node.
         */
        public String getName() {
            return this.item;
        }
    }
    /**
     * check whether stack is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * push method is used to push the item.
     * @param item element to push.
     */
    public void push(final String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    /**
     * pop method is to remove the item.
     * @return the poped element.
     */
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
    /**
     * Gives the top node.
     * @return first or top Node.
     */
    public Node getFirst() {
        return first;
    }
}
/**
 * Solution class contain main method and other methods.
 */
public final class Solution {
    /**
     * default Solution constructor.
     */
    private Solution() {

    }
    /**
     * main method takes the inputs and send it to linkedstack class.
     *
     * @param args command args.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            int flag = 0;
            LinkedStack link = new LinkedStack();
            String[] str = scan.nextLine().split("");
            //System.out.println(Arrays.toString(str));
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("[") || str[i].equals(
                    "{") || str[i].equals("(")) {
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
