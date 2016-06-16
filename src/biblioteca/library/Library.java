package biblioteca.library;

import biblioteca.io.LibraryIO;

import java.util.Arrays;
import java.util.List;

//Understands lending of books
public class Library {

    private BookList inventory;
    private LibraryIO libraryIO;
    private BookList checkedOut;

    public Library(BookList inventory, LibraryIO libraryIO, BookList checkedOut) {
        this.inventory = inventory;
        this.libraryIO = libraryIO;
        this.checkedOut = checkedOut;
    }

    public Library(BookList inventory, LibraryIO libraryIO) {
        this(inventory, libraryIO, new BookList());
    }

    private void mainMenu() {
        boolean restart = true;
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book", "Return Book");
        while (restart) {
            int choice = libraryIO.mainMenu(menuItems);
            restart = execute(choice);
        }
    }

    private boolean execute(int choice) {
        if (choice == 1) {
            libraryIO.printBookList(inventory, "%50s %30s %15s\n");
            return true;
        }
        if (choice == 0) {
            return false;
        }
        if (choice == 2) {
            checkout();
            return true;
        }
        if (choice == 3) {
            returnBook();
            return true;
        }
        libraryIO.invalidOption();
        return true;
    }

    @Override
    public String toString() {
        return "Library{" +
                "inventory=" + inventory +
                ", libraryIO=" + libraryIO +
                ", checkedOut=" + checkedOut +
                '}';
    }

    public void enter() {
        libraryIO.display("Welcome to Biblioteca!");
        mainMenu();
    }

    private void checkout() {
        libraryIO.display("Enter title of book to checkout: ");
        String bookTitle = libraryIO.inputBookTitle();
        Book foundBook = inventory.findBookByName(bookTitle);
        if (foundBook != null) {
            inventory.remove(foundBook);
            checkedOut.add(foundBook);
            libraryIO.display("Thank you! Enjoy the book!");
            return;
        }
        foundBook = checkedOut.findBookByName(bookTitle);
        if (foundBook != null) {
            libraryIO.display("Sorry that book is checked out!");
            return;
        }
        libraryIO.display("Sorry that book does not exist!");
    }

    private void returnBook() {
        libraryIO.display("Enter title of book to return: ");
        String bookTitle = libraryIO.inputBookTitle();
        Book foundBook = checkedOut.findBookByName(bookTitle);
        if (foundBook != null) {
            checkedOut.remove(foundBook);
            inventory.add(foundBook);
            libraryIO.display("Thank you for returning the book!");
        }
        foundBook = inventory.findBookByName(bookTitle);
        if (foundBook != null) {
            libraryIO.display("That book has not been checked out!");
            return;
        }
        libraryIO.display("Sorry that book does not exist!");
    }
}
