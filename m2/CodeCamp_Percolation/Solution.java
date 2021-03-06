import java.util.Scanner;
// public class Percolation {
//     public Percolation(int n)
// create n-by-n grid, with all sites blocked
//     public    void open(int row, int col)
// open site (row, col) if it is not open already
//     public boolean isOpen(int row, int col)
// is site (row, col) open?
//     public boolean isFull(int row, int col)
// is site (row, col) full?
//     public     int numberOfOpenSites()
// number of open sites
//     public boolean percolates()
// does the system percolate?
// }

// You can implement the above API to solve the problem
/**
 * In percolation class we define different methods.
 * Such as Open, isopen, perculation methods.
 */
class Percolation {
    /**
     * grid array stores the boolean values.
     */
    private boolean[][] grid;
    /**
     * creating WeightQuickUnionUF object.
     */
    private WeightedQuickUnionUF uf;
    /**
     * varaible for number of open sites.
     */
    private int numberOfOpenSites = 0;
    /**
     * variable to count size.
     */
    private int size;
    /**
     * variable grid size is useful for virtual nodes.
     */
    private int gridsize;
    /**
     * percolation constructor for initializing the size.
     *
     * @param size1 to count size.
     */
    Percolation(final int size1) {
        grid = new boolean[size1][size1];
        uf = new WeightedQuickUnionUF(size1 * size1 + 2);
        numberOfOpenSites = 0;
        this.size = size1;
        gridsize = size1 * size1;
    }
    /**
     * In open method, we use isOpen to to find
     * whether it is open and then we use union to connect two point in grid.
     *
     * @param row grid row value.
     * @param col grid column value.
     */
    public void open(final int row, final int col) {
        if (grid[row][col]) {
            return;
        }
        grid[row][col] = true;
        numberOfOpenSites++;

        //top
        if (row - 1 >= 0 && isOpen(row - 1, col)) {
            uf.union(getIndexOf(row, col), getIndexOf(row - 1, col));
        }

        //left
        if (col - 1 >= 0 && isOpen(row, col - 1)) {
            uf.union(getIndexOf(row, col), getIndexOf(row, col - 1));
        }

        //right
        if (col + 1 < size && isOpen(row, col + 1)) {
            uf.union(getIndexOf(row, col), getIndexOf(row, col + 1));
        }

        //bottom
        if (row + 1 < size && isOpen(row + 1, col)) {
            uf.union(getIndexOf(row, col), getIndexOf(row + 1, col));
        }

        if (row == 0) {
            uf.union(getIndexOf(row, col), gridsize);
        }

        if (row == size - 1) {
            uf.union(getIndexOf(row, col), gridsize + 1);
        }
    }

    /**
     * Isopen return true if the grid element is open else false.
     *
     * @param row row value.
     * @param col column value.
     *
     * @return boolean value true or false.
     */
    public boolean isOpen(final int row, final int col) {
        return grid[row][col];
    }

    /**
     * this is used to track number of opensites.
     * @return number of opensites.
     */
    public int countOfOpenSites() {
        return numberOfOpenSites;
    }

    /**
     * It will give value at that particular position in array.
     *
     * @param row row value.
     * @param col column value.
     *
     * @return the value at that particular position in array.
     */
    public int getIndexOf(final int row, final int col) {
        return size * (row) + col;
    }

    /**
     * percolates is used find whether we can percolate to entire grid.
     * @return true or false.
     */
    public boolean percolates() {
        return uf.connected(gridsize, gridsize + 1);
    }
}

/**
 * In Solution we Start the main program.
 */
public final class Solution {
    /**
     * defalut Solution constructor.
     */
    private Solution() {

    }
    /**
     * In main method we take the input of array size,
     * and row and column values.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Percolation perculate = new Percolation(scan.nextInt());
        while (scan.hasNext()) {
            perculate.open(scan.nextInt() - 1, scan.nextInt() - 1);
        }
        System.out.println(perculate.percolates());
    }
}
