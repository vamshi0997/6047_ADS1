import java.util.Scanner;
/**
 * Solution class contain main method.
 */
public final class Solution {
    /**
     * default private constructor.
     */
    private Solution() {
    }
    /**
     * the main method is used to handle input.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DynamicMedian dynamic = new DynamicMedian();
        long input = scan.nextLong();
        double element = scan.nextDouble();
        dynamic.insertAtMin(element);
        double median = element;
        System.out.println(median);
        for (long i = 1; i < input; i++) {
            double arrinput = scan.nextDouble();
            if (arrinput > median) {
                dynamic.insertAtMin(arrinput);
            } else if (arrinput < median) {
                dynamic.insertAtMax(arrinput);
            } else {
                dynamic.insertAtMin(arrinput);
            }
            if (dynamic.getMinSize() - dynamic.getMaxSize() > 1) {
                dynamic.insertAtMax(dynamic.delMin());
            }
            if (dynamic.getMaxSize() - dynamic.getMinSize()  > 1) {
                dynamic.insertAtMin(dynamic.delMax());
            }
            if (Math.abs(
                        dynamic.getMinSize() - dynamic.getMaxSize()) == 1) {
                if (dynamic.getMinSize() > dynamic.getMaxSize()) {
                    median = dynamic.getMin();
                    System.out.println(median);
                } else {
                    median = dynamic.getMax();
                    System.out.println(median);
                }
            }
            if (dynamic.getMinSize()  == dynamic.getMaxSize()) {
                double min = dynamic.getMin();
                double max = dynamic.getMax();
                median = (min + max) / 2.0;
                System.out.println(median);
            }
        }
    }
}