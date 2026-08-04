package Assignment9;

class LibraryBook {
    final String isbn;
    String title;
    String author;
    double price;

    LibraryBook(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBookDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.printf("Price: Rs.%.2f\n", price);
        System.out.println("------------------------------------");
    }
}

public class finalLibraryBook {
    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("978-1302965549", "Civil War", "Mark Millar", 1399.99);
        System.out.println("Book 1 Details:");
        book1.displayBookDetails();

        LibraryBook book2 = new LibraryBook(" 978-1302972547", "Thor: Gorr The God Butcher", "Jason Aaron", 1599.99);
        System.out.println("Book 2 Details:");
        book2.displayBookDetails();
    }
}