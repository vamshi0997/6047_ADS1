import java.util.Arrays;
/**
 * Class for merge where two elements are sorted.
 */
public class Merge {
    /**
     * Constructs the object.
     */
    Merge() {

    }
    /**
     * Time complexity is O(logN).
     * sorting two arrays into a single array.
     * @param firstarr int array
     * @param secondarr int array
     */
    public void mergesort(final int[] firstarr, final int[] secondarr) {
        int i = 0;
        int j = 0;
        int[] result;
        result = new int[firstarr.length + secondarr.length];
        for (int k = 0; k < result.length; k++) {
            if (i < firstarr.length && j < secondarr.length) {
                if (firstarr[i] < secondarr[j]) {
                    result[k] = firstarr[i++];
                } else {
                    result[k] = secondarr[j++];
                }
            } else if (i >= firstarr.length) {
                result[k] = secondarr[j++];
            } else if (j >= secondarr.length) {
                result[k] = firstarr[i++];
            }
        }
        System.out.println(
            Arrays.toString(result).replace(
                "[", "").replace("]", "").replace(" ", ""));
    }
}
