import java.util.Scanner;
// public class Percolation {
//     public Percolation(int n)                // create n-by-n grid, with all sites blocked
//     public    void open(int row, int col)    // open site (row, col) if it is not open already
//     public boolean isOpen(int row, int col)  // is site (row, col) open?
//     public boolean isFull(int row, int col)  // is site (row, col) full?
//     public     int numberOfOpenSites()       // number of open sites
//     public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem

class Percolation {
	private boolean[][] grid;
	private WeightedQuickUnionUF uf;
	private int numberOfOpenSites = 0;
	private int size;
	private int gridsize;

	Percolation(int size) {
        grid = new boolean[size][size];
        uf = new WeightedQuickUnionUF(size * size + 2);
        numberOfOpenSites = 0;
        this.size = size;
        gridsize = size * size; 
	}

	public void open(int row, int col) {
        //System.out.println(row +"-"+s col);
		if (grid[row][col]) return;
		grid[row][col] = true;
		numberOfOpenSites++;

		//top
		if (row - 1 >= 0 && isOpen(row - 1, col)) {
            uf.union(getIndexOf(row,col), getIndexOf(row - 1, col));
            //System.out.println("1");
		}
        
        //left
        if (col - 1 >= 0 && isOpen(row, col - 1)) {
            uf.union(getIndexOf(row,col), getIndexOf(row, col - 1));
            //System.out.println("2");
        }

        //right
        if (col + 1 < size && isOpen(row, col + 1)) {
        	uf.union(getIndexOf(row,col), getIndexOf(row, col + 1));
        	//System.out.println("3");
        }

        //bottom
        if (row + 1 < size && isOpen(row + 1, col)) {
        	uf.union(getIndexOf(row,col), getIndexOf(row + 1, col));
        	//System.out.println("4");
        }

        if (row == 0) {
        	uf.union(getIndexOf(row, col), gridsize);
        }

        if (row == size-1) {
        	uf.union(getIndexOf(row, col), gridsize + 1);
        }
        //System.out.println("hi");
	}

	public boolean isOpen(int row, int col) {
		return grid[row][col];
	}

	public int countOfOpenSites() {
		return numberOfOpenSites;
	}

	public int getIndexOf(int row, int col) {
		return size * (row) + col;
	}

	public boolean percolates() {
		//System.out.println("hi");
        return uf.connected(gridsize, gridsize + 1);
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Percolation Perculate = new Percolation(scan.nextInt());
		//System.out.println(Perculate.percolates());
		while(scan.hasNext()) {
			Perculate.open(scan.nextInt()-1, scan.nextInt()-1);
		}

		System.out.println(Perculate.percolates());
	}
}