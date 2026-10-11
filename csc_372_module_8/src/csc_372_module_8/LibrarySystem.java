package csc_372_module_8;

import java.util.Scanner;
import java.util.InputMismatchException;

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice = 0;

        while (choice != 6) {

            System.out.println();
            System.out.println("===== Library System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {

                    System.out.print("Enter book ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter book title: ");
                    String title = input.nextLine();

                    System.out.print("Enter author: ");
                    String author = input.nextLine();

                    System.out.print("Enter ISBN number: ");
                    String isbn = input.nextLine();

                    System.out.print("Enter number of pages: ");
                    int numberOfPages = input.nextInt();
                    input.nextLine();

                    Book book = new Book(
                        id, title, author, isbn, numberOfPages
                    );

                    if (inventory.addBook(book)) {
                        System.out.println(
                            "Book added to the library."
                        );
                    } else {
                        System.out.println(
                            "A book with that ID already exists."
                        );
                    }

                } else if (choice == 2) {

                    System.out.print(
                        "Enter the ID of the book to borrow: "
                    );
                    int borrowId = input.nextInt();
                    input.nextLine();

                    if (inventory.borrowBook(borrowId)) {
                        System.out.println(
                            "Book successfully borrowed."
                        );
                    } else {
                        System.out.println(
                            "Book not found or already borrowed."
                        );
                    }

                } else if (choice == 3) {

                    System.out.print(
                        "Enter the ID of the book to return: "
                    );
                    int returnId = input.nextInt();
                    input.nextLine();

                    if (inventory.returnBook(returnId)) {
                        System.out.println(
                            "Book successfully returned."
                        );
                    } else {
                        System.out.println(
                            "Book not found in the lending inventory."
                        );
                    }

                } else if (choice == 4) {

                    System.out.print(
                        "Enter a book title to search: "
                    );
                    String searchTitle = input.nextLine();

                    if (!inventory.searchByTitle(searchTitle)) {
                        System.out.println(
                            "No matching book found."
                        );
                    }

                } else if (choice == 5) {

                    System.out.println();
                    System.out.println("===== Available Books =====");
                    inventory.printAll();

                    System.out.println(
                        "Available book count: "
                        + inventory.getMainInventoryCount()
                    );

                } else if (choice == 6) {

                    System.out.println(
                        "Exiting the program. Goodbye!"
                    );

                } else {

                    System.out.println(
                        "Invalid option. Please enter a number from 1 to 6."
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                    "Invalid input. Please enter a number where required."
                );

                input.nextLine();
            }
        }

        input.close();
    }
}
