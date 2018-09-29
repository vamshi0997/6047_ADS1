import java.util.Scanner;
class AddLargeNumbers {
    //LinkedList<Character> link = new LinkedList<Character>();
    
    public static LinkedList numberToDigits(String number) {
        LinkedList<Character> link = new LinkedList<Character>();
        for (int i = number.length() - 1; i >= 0; i--) {
            link.add(0, number.charAt(i));
            //System.out.print(number.charAt(i));
        }
        //link.retrive();
        return link;
    }

    public static String digitsToNumber(LinkedList list) {
        //System.out.println(list.display());
        //list.display();
        return list.display();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
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
