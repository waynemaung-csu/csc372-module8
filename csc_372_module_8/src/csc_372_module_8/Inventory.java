package csc_372_module_8;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Book> mainInventory;
    private ArrayList<Book> lendingInventory;

    public Inventory() {
        mainInventory = new ArrayList<Book>();
        lendingInventory = new ArrayList<Book>();
    }

    // adds book if id is not already in use
    public boolean addBook(Book book) {
        for (Book existingBook : mainInventory) {
            if (existingBook.getId() == book.getId()) {
                return false;
            }
        }

        for (Book existingBook : lendingInventory) {
            if (existingBook.getId() == book.getId()) {
                return false;
            }
        }

        mainInventory.add(book);
        return true;
    }

    // borrow book using id
    public boolean borrowBook(int id) {
        for (int i = 0; i < mainInventory.size(); i++) {
        		Book book = mainInventory.get(i);
            if (book.getId() == id) {
                lendingInventory.add(book);
                mainInventory.remove(i);
                return true;
            }
        }

        return false;
    }

    // returns borrowed book using id
    public boolean returnBook(int id) {
    		for (int i = 0; i < lendingInventory.size(); i++) {
            Book book = lendingInventory.get(i);

            if (book.getId() == id) {
                mainInventory.add(book);
                lendingInventory.remove(i);
                return true;
            }
        }

        return false;
    }

    // prints all available books
    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("No books are currently available.");
            return;
        }

        for (Book book : mainInventory) {
            book.printBookInfo();
        }
    }

    // searches available books by full or partial title
    public boolean searchByTitle(String title) {
        boolean found = false;

        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.printBookInfo();
                found = true;
            }
        }

        return found;
    }

    // returns number of available books
    public int getMainInventoryCount() {
        return mainInventory.size();
    }
}
