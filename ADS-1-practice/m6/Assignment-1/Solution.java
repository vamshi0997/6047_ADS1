import java.util.Scanner;
/**
 * Adding AddLargeNumbers.
 */
class AddLargeNumbers {
    //LinkedList<Character> link = new LinkedList<Character>();
    /**
     * @param number String.
     * @return Linkedlist.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList<Character> link = new LinkedList<Character>();
        for (int i = number.length() - 1; i >= 0; i--) {
            link.add(0, number.charAt(i));
        }
        return link;
    }
    /**
     * @param list Linkedlist.
     * @return String.
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.display();
    }
    /**
     * @return Linkedlist
     */
    public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {
        //int a = Integer.valueOf((Character) list1.remove(0));
        System.out.println(list1.remove(0) + list1.remove(0));
        
        for (int i = list1.size(); i > 0; i--) {
            //stack.add(list1.remove(0));
        }
        list1.display();
        return null;
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
        switch(input) {
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
