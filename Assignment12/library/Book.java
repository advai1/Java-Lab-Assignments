package Assignment12.library;

public class Book {
    int bookId;
    String title, author;
    double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("ID: " + bookId + " | Title: " + title + " | Author: " + author + " | Price: " + price);
    }
}