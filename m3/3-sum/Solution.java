import java.util.Scanner;
public final class Solution {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int m = 0; m < size; m++) {
			arr[m] = scan.nextInt();
		}
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				for (int k = j+1 ; k < size; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0) {
                    	count ++;
                    	break;
                    }
				}
			}
		}
		System.out.println(count);
	}

}