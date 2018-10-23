/**
 * Book class contain book name, author, price.
 */
class Book implements Comparable<Book> {
    /**
     * name of book.
     */
    private String name;
    /**
     * author name of book.
     */
    private String author;
    /**
     * price of the book.
     */
    private float price;
    /**
     * Time complexity is O(1).
     * Book class constructor.
     *
     * @param name1 name.
     * @param author1 author.
     * @param price1 price.
     */
    Book(final String name1, final String author1, final float price1) {
    this.name = name1;
    this.author = author1;
    this.price = price1;
    }
    /**
     * get name method return name of book.
     * @return name of book.
     */
    String getName() {
        return this.name;
    }
    /**
     * get author method return name of book author.
     * @return name of book author..
     */
    String getAuthor() {
        return this.author;
    }
    /**
     * get price method return price of book.
     * @return price of book.
     */
    float getPrice() {
        return this.price;
    }
    /**
     * Time complexity is O(1).
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name + ", " + this.author + ", " + this.price;
    }
    /**
     * Time complexity is O(1).
     * compares the two differnt book names.
     *
     * @param that book object.
     * @return integer value.
     */
    public int compareTo(final Book that) {
        return this.getName().compareTo(that.getName());
    }
}
