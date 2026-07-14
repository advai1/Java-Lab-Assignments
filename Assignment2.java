class Book {

    String title;
    String author;
    int pages;

    //Default Constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Author Unknown";
        this.pages = 0;
        System.out.println("---Default constructor called.---");


    }
    //Parameterized Constructor
    public Book(String bookTitle, String author, int bookPages) {
        this.title = bookTitle;
        this.author = bookAuthor
        this.pages = bookPages;
        System.out.println("---Parameterized constructor called.---");

    }
    //Copy Constructor
    public Book(Book otherBook) {
        this.title = otherBook.title;
        this.author = otherBook.author;
        this.pages = otherBook.pages;
        System.out.println("---Copy constructor called.---");
    }

    public void displayInfo() {
        System.out.println("Title: " + title + "\n Author: " + author+ "\n Pages: " + pages);
        System.out.println("============================================")
    }
}

public class Main {
    public static void main(String[] args) {

        // using the Default Constructor
        Book book1 = new Book();
        book1.displayInfo();

        //using the Parameterized Constructor
        Book book2 = new Book("Kraven's Last Hunt", "J.M. DeMatteis" 168);
        book2.displayInfo();

        //using the Copy Constructor
        Book book3 = new Book(book2);
        book3.displayInfo();
    }
}

