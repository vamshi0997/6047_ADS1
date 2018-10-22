/**
 * MergeSort contains methods merge, sort, 
 */
class MergeSort {
    /**
     * cutoff to InsertionSort.
     */
    private final int cutoff = 7;
    /**
     * default constructor.
     */
    MergeSort() {
    }
    /**
     * Merge method is used to merge two arrays.
     * Time complexity of this method is O(N).
     * @param array array
     * @param auxilary auxiliary
     * @param low lower value
     * @param mid middle value
     * @param high higher value
     */
    public void merge(final Comparable[] array, final Comparable[] auxilary,
        final int low, final int mid, final int high) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, high);
        int i = low;
        int j = mid + 1 ;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                auxilary[k] = array[j++];
            } else if (j > high) {
                auxilary[k] = array[i++];
            } else if (less(array[j], array[i])) {
                auxilary[k] = array[j++];
            } else {
                auxilary[k] = array[i++];
            }
        }
        assert isSorted(auxilary, low, high);
    }
    /**
     * sort elements in array.
     * Time complexity of sorting is O(NlogN).
     * @param array array.
     * @param auxilary temparary array.
     * @param low low value in array.
     * @param high high value in array.
     */
    public void sort(final Comparable[] array, final Comparable[] auxilary,
        final int low, final int high) {
        if (high <= low + cutoff) {
            insertionSort(auxilary, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(auxilary, array, low, mid);
        sort(auxilary, array, mid + 1, high);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = low; i <= high; i++) {
                auxilary[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, auxilary, low, mid, high);
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     * Time complexity of this method is O(NlogN).
     * @param cmp Comparable array.
     */
    public void sort(final Comparable[] cmp) {
        Comparable[] auxilary = cmp.clone();
        sort(auxilary, cmp, 0, cmp.length - 1);
        assert isSorted(cmp);
    }
    /**
     * InsertionSort for sorting.
     * sort from cmp[low] to cmp[high].
     * Time complexity of insertion sort is O(N^2/2).
     * @param cmp Comparable array.
     * @param low lower array value.
     * @param high higher array value.
     */
    public void insertionSort(final Comparable[] cmp,
        final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(cmp[j], cmp[j - 1]); j--) {
                exchange(cmp, j, j - 1);
            }
        }
    }
    /**
     * {Method to exchange two elements in the array}.
     * Time complexity of this method is O(N).
     * @param cmp comparable object.
     * @param i Integer i
     * @param j Integer j
     */
    public void exchange(final Comparable[] cmp,
        final int i, final int j) {
        Comparable swap = cmp[i];
        cmp[i] = cmp[j];
        cmp[j] = swap;
    }
    /**
     * {Method to check which one is smaller of the two}.
     * Time complextiy of this method is O(1).
     * @param cmp Comparable.
     * @param b comparable.
     *
     * @return true if sorted else false.
     */
    public boolean less(final Comparable cmp, final Comparable b) {
        return cmp.compareTo(b) < 0;
    }
    /**
     * Method to determine if the array is sorted (or) not.
     * Time complexity of this method is O(1).
     * @param cmp Comparable array
     *
     * @return true if sorted else false.
     */
    public boolean isSorted(final Comparable[] cmp) {
        return isSorted(cmp, 0, cmp.length - 1);
    }
    /**
     * Method to determine if the array is sorted (or) not.
     * Time complexity of this method is O(N).
     * @param cmp Comparable array
     * @param low lower array bvalue.
     * @param high higher array value.
     *
     * @return true if sorted else False otherwise.
     */
    public boolean isSorted(final Comparable[] cmp,
        final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {//
            if (less(cmp[i], cmp[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * show method to print the values of the Comparable array.
     * Time complexity of this method is O(N).
     * @param cmp comparable array.
     *
     * @return String as result.
     */
    public String show(final Comparable[] cmp) {
        String str1 = "[";
        int i;
        for (i = 0; i < cmp.length - 1; i++) {
            str1 += cmp[i] + ", ";
        }
        str1 += cmp[i] + "]";
        return str1;
    }
}
