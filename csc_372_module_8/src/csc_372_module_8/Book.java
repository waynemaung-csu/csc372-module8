package csc_372_module_8;

public class Book {

    private int id;
    private String title;
    private String author;
    private String isbn;
    private int numPages;

    public Book() {
        id = 0;
        title = "";
        author = "";
        isbn = "";
        numPages = 0;
    }

    public Book(int id, String title, String author, String isbn, int numPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numPages = numPages;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumberOfPages() {
        return numPages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numPages = numberOfPages;
    }

    // book info
    public void printBookInfo() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Number of Pages: " + numPages);
        System.out.println("----------------------------");
    }
}
