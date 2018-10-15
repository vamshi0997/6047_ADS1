class Stock implements Comparable<Stock> {
	private String name;
	private Double change;
	Stock(String name1, Double change1) {
		this.name = name1;
		this.change = change1;
	}
	String getName() {
		return this.name;
	}
	Double getChange() {
		return this.change;
	}

	String tostr() {
		return this.name + " " + this.change;
	}
	
	public int compareTo(Stock that) {
        if(this.change > that.change) {
        	return 1;
        }
        else if( this.change < that.change) {
        	return -1;
        }
        int a = that.getName().compareTo(this.getName());
        if (a > 0) {
        	return -1;
        } else {
        	return 1;
        }
        // else {
        //     return that.getName().compareTo(this.getName());
        // }
	}
}