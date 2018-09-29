import java.util.Scanner;
class AddLargeNumbers {
    //LinkedList<Character> link = new LinkedList<Character>();
    
    public static LinkedList numberToDigits(String number) {
        LinkedList<Character> link = new LinkedList<Character>();
        for (int i = number.length() - 1; i >= 0; i--) {
            link.add(0, number.charAt(i));
        }
        return link;
    }

    public static String digitsToNumber(LinkedList list) {
        return list.display();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        //int a = Integer.valueOf((char) list1.remove(0));
        //int a = Character.getNumericValue(list1.remove(0));
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        LinkedStack<Integer> stack1 = new LinkedStack<Integer>();
        LinkedStack<Integer> stack2 = new LinkedStack<Integer>();
        //System.out.println(list1.remove(0) + list1.remove(0));
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.remove(0));
            //System.out.println(Integer.valueOf((char) list1.remove(0)));
            //stack.push(Integer.valueOf((char) list1.remove(0)));
        }
        // while(!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        // }

        // for (int j = 0; j < list2.size(); j++) {
        //     stack.push(list2.remove(0));
        // }

        return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
