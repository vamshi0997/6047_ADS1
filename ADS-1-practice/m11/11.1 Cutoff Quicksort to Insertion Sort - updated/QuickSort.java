/**
 * QuickSort class contains methods for the sort.
 */
class QuickSort {
    // /**
    //  * 
    //  */
    // QuickSort() {
    // }
    /**
     * time complexity for this method is O(N^2).
     * sort the given array.
     *
     * @param cmp The array
     * @param low first array index.
     * @param high last array index.
     */
    public void insert(final Comparable[] cmp,
        final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(cmp[j], cmp[j - 1]); j--) {
                exchange(cmp, j, j - 1);
            }
        }
    }

    /**
     * time complexity is O(log N)
     * sort the given arrays.
     *
     * @param cmp The array
     * @param low first array index.
     * @param high last array index.
     * @param cutOff gives the cutoff value.
     */
    public void sort(final Comparable[] cmp, final int low,
     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insert(cmp, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(cmp, low, high);
        System.out.println(toString(cmp));
        sort(cmp, low, k - 1, cutOff);
        sort(cmp, k + 1, high, cutOff);
    }

    /**
     * time complexity is O(1)
     * sort method.
     *
     * @param cmp The array
     * @param cutOff cutoff value.
     */
    public void sort(final Comparable[] cmp, final int cutOff) {
        sort(cmp, 0, cmp.length - 1, cutOff);
    }

    /**
     * time complexity is O(N)
     * Method to partition elements of the array.
     * @param cmp  The cmp
     * @param low  The low
     * @param high  The high
     *
     * @return     integer
     */
    public int partition(final Comparable[] cmp,
     final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(cmp[++i], cmp[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(cmp[low], cmp[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(cmp, i, j);
        }
        exchange(cmp, low, j);
        return j;
    }

    /**
     * time complexity of this method is O(1).
     * exchange method Swap the given elements.
     *
     * @param cmp The array
     * @param element  The given element.
     * @param minimum minimum element.
     */
    public void exchange(final Comparable[] cmp, final int element, final int minimum) {
        Comparable temp = cmp[element];
        cmp[element] = cmp[minimum];
        cmp[minimum] = temp;
    }

    /**
     * time complexity is O(1)
     * to compare two given elements by using comparable.
     * @param element1 first element.
     * @param element2 second element.
     *
     * @return boolean value true or false.
     */
    public boolean less(final Comparable element1, final Comparable element2) {
        return element1.compareTo(element2) < 0;
    }

    /**
     * time complexity of this method is O(N).
     * This method return the String given object class.
     *
     * @param cmp The array
     *
     * @return String.
     */
    public String toString(final Comparable[] cmp) {
        String str1 = "[";
        for (int i = 0; i < cmp.length - 1; i++) {
            str1 += cmp[i] + ", ";
        }
        str1 += cmp[cmp.length - 1] + "]";
        return str1;
    }
}
