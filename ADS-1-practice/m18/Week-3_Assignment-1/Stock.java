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
	Double getchange() {
		return this.change;
	}

	String tostr() {
		return this.name + " " + this.change;
	}
	
	public int compareTo(Stock that) {
        if(this.change > that.change) {
        	return -1;
        }
        if( this.change < that.change) {
        	return 1;
        }
        return this.getName().compareTo(this.getName());
	}
}