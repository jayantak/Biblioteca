package library;

import java.util.Arrays;
import java.util.List;

//Understands lending of books
public class Library {

    private BookList inventory;
    private BookList checkedOut = new BookList();
    private LibraryIO libraryIO;

    public Library(BookList inventory, LibraryIO libraryIO) {
        this.inventory = inventory;
        this.libraryIO = libraryIO;
    }

    Library(BookList bookList) {
        this(bookList, new ConsoleIO());
    }

    BookList bookList() {
        return inventory;
    }

    private void mainMenu() {
        boolean restart = true;
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book");
        while (restart) {
            int choice = libraryIO.mainMenu(menuItems);
            restart = execute(choice);
        }
    }

    private boolean execute(int choice) {
        if (choice == 1) {
            libraryIO.printBookList(inventory, "%30s %30s %30s\n");
            return true;
        }
        if (choice == 0) {
            return false;
        }
        if (choice == 2) {
            checkout();
            return true;
        }
        libraryIO.invalidOption();
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        return inventory != null ? inventory.equals(library.inventory) : library.inventory == null;

    }

    @Override
    public String toString() {
        return "Library{" +
                "inventory=" + inventory +
                '}';
    }

    public void enter() {
        libraryIO.display("Welcome to Biblioteca!");
        mainMenu();
    }

    public void checkout() {
        libraryIO.display("Enter title of book to checkout: ");
        String booktitle = libraryIO.inputBookTitle();
        Book foundBook = inventory.findBookByName(booktitle);
        if (foundBook != null) {
            inventory.remove(foundBook);
        }
    }
}
