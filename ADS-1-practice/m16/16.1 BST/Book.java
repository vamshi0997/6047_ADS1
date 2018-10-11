class Book implements Comparable<Book> {
	String name;
	String author;
	float price;
	Book(String name1, String author1, float price1) {
	this.name = name1;
	this.author = author1;
	this.price = price1;
	}

	String getName() {
		return this.name;
	}

	String getAuthor() {
		return this.author;
	}

	float getPrice() {
		return this.price;
	}
	public int compareTo(Book that) {
		return this.getName().compareTo(that.getName());
	}


}