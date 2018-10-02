import java.util.Scanner;
/**
 * Adding AddLargeNumbers.
 */
class AddLargeNumbers {
    /**
     * @param number String.
     * @return Linkedlist.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList link = new LinkedList();
        String[] num = number.split("");
        for (int i = num.length - 1; i >= 0; i--) {
            link.insertAtStart(num[i]);
        }
        return link;
    }

    /**
     * @param list Linkedlist.
     * @return String.
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.display1();
    }
    /**
     * @param
     * @return Linkedlist
     */
    public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {
        LinkedStack<String> stack1 = new LinkedStack<String>();
        LinkedStack<String> stack2 = new LinkedStack<String>();
        LinkedList linklist = new LinkedList();
        final int ten = 10;
        Node temp = new Node();
        temp.link = list1.head; 
        while(temp.link != null) {
            stack1.push(temp.data);
            temp = temp.link;
        }
        stack1.push(temp.data);
        Node temp1 = new Node();
        temp1.link = list2.head;
        while(temp1.link != null) {
            stack2.push(temp1.data);
            temp1 = temp1.link;
        }
        stack2.push(temp1.data);
        int num1 = 0, num2 = 0, result = 0, ntemp = 0;
        String str = "";
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()) {
                num2 = Integer.parseInt(stack2.pop());
                result = num2 + ntemp;

            } else if (!stack2.isEmpty()) {
                num1 = Integer.parseInt(stack1.pop());
                result = num1 + ntemp;
            } else {
                str = "";
                num1 = Integer.parseInt(stack1.pop());
                num2 = Integer.parseInt(stack2.pop());
                result = num1 + num2 + ntemp;
                str += "" + result;
                if(str.length() == 2) {
                    String[] str1 = str.split("");
                    ntemp = Integer.parseInt(str1[0]);
                    linklist.insertAtStart(str1[1]);
                } else {
                    ntemp = 0;
                    linklist.insertAtStart(Integer.toString(result));
                }
            linklist.insertAtStart(Integer.toString(result));

            }
        }
        // int result = 0, firstele = 0, secele = 0, temp2 = 0;
        //  while (!stack1.isEmpty() || !stack2.isEmpty()) {
        //     if (stack1.isEmpty()) {
        //         secele = Integer.parseInt(stack2.pop());
        //         temp2 = result / ten;
        //         result = secele + temp2;
        //     } else if (stack2.isEmpty()) {
        //         firstele = Integer.parseInt(stack1.pop());
        //         temp2 = result / ten;
        //         result = firstele + temp2;
        //     } else {
        //         firstele = Integer.parseInt(stack1.pop());
        //         secele = Integer.parseInt(stack2.pop());
        //         temp2 = result / ten;
        //         result = firstele + secele + temp2;
        //     }
        //     linklist.insertAtStart(Integer.toString(result % ten));
        // }
        // if (stack1.size == stack2.size) {
        //     linklist.insertAtStart(Integer.toString(result / ten));
        // }
        return linklist;
    }
        
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * @param args command line.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result =
                AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
            default:
                break;
        }
    }
}
