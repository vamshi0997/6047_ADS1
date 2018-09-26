import java.util.Scanner;
import java.util.Arrays;
/**
 * In solution class we have main method and other methods.
 */
class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size1 = Integer.parseInt(scan.nextLine());
        int size2 = Integer.parseInt(scan.nextLine());
        // if (size1 > 0) {
        //     String[] first = scan.nextLine().split(",");
        //     System.out.println(Arrays.toString(first));
        // }
        // if (size2 > 0) {
        //     String[] second = scan.nextLine().split(",");
        //     //System.out.println(Arrays.toString(first));
        //     System.out.println(Arrays.toString(second));
        // }
        String[] first = scan.nextLine().split(",");
        String[] second = scan.nextLine().split(",");
        
        int[] firstarr;
        int[] secondarr;
        secondarr = new int[second.length];

        if(first[0].equals("")) {
            firstarr = new int[0];
        }
        else {
            firstarr = new int[first.length];
            for(int i = 0; i<first.length; i++) {
            firstarr[i] = Integer.parseInt(first[i]);
        }

        }
        for(int i = 0; i<second.length; i++) {
            secondarr[i] = Integer.parseInt(second[i]);
        }

        //sort(firstarr, secondarr);

    }

    public static void sort(int[] firstarr, int[] secondarr) {
        int i = 0;
        int j = 0;
        int [] result;
        result = new int[firstarr.length+secondarr.length];
        for(int k = 0; k<result.length; k++) {
            if(i<firstarr.length && j<secondarr.length) {
                if(firstarr[i] < secondarr[j]) {
                    result[k] = firstarr[i++];
                }
                else
                    result[k] = secondarr[j++];
            }
            else if(i>=firstarr.length) {
                result[k] = secondarr[j++];
            }
            else if(j>=secondarr.length) {
                result[k] = firstarr[i++];
            }
        }
        System.out.println(Arrays.toString(result).replace("[", "").replace("]","").replace(" ",""));
    }

}