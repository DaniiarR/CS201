import java.util.Arrays;

public class Book {

    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        String authorsString = "";
        for (int i = 0; i < authors.length; i++) {
            if (i < authors.length - 1) {
                authorsString += authors[i].toString() + ", ";
            } else {
                authorsString += authors[i].toString();
            }
        }
        return String.format("Book[name=%s, authors=={%s}, price=%.1f, qty=%d]", getName(), authorsString, getPrice(), getQty());
    }
}
