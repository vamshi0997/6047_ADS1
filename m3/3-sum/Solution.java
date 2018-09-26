import java.util.Scanner;
public final class Solution {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		int count = 0;
		for (int i = 0; i < size-2; i++) {
			for (int j = i+1; j < size-1; j++) {
				for (int k = j+1 ; k < size; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0) {
                    	count += 1;
                    	break;
                    }
				}
			}
		}
		System.out.println(count);
	}

}