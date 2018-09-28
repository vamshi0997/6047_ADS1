import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[scan.nextInt()];
		for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int number = 0;
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] == arr[i+1] && temp != arr[i]) {
                number += find(arr, arr[i]);
                temp = arr[i];
			}
		}
		System.out.println("total no of pairs: " + number);
    }

	public static int find (int[] arr, int number) {
		int pairvalue = 0;
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == number) {
				count ++;
			}
		}
		if (count > 1) {
			pairvalue += count * (count-1) / 2;
		}
	    return pairvalue;
	}

}