import java.util.Arrays;
/**
 * Class for three sum which has sum method.
 */
class ThreeSum {
    /**
     * sum method counts the number of times
     * the sum of three numbers is zero.
     * it return the count value.
     *
     * @param      arr   The arr
     * @param      size  The size
     *
     * @return     count.
     */
    public int sum(final int[] arr, final int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int k = Arrays.binarySearch(arr, -(arr[i] + arr[j]));
                if (k > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
