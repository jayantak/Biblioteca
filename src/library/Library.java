package library;

import java.io.FileNotFoundException;

//Understands lending of books
public class Library {

    private BookList inventory;
    private LibraryIO libraryIO;

    public Library(BookList inventory, LibraryIO libraryIO) {
        this.inventory = inventory;
        this.libraryIO = libraryIO;
    }

    Library(BookList bookList) {
        this(bookList, new ConsoleIO());
    }

    BookList bookList() throws FileNotFoundException {
        return inventory;
    }

    private void printBookList(String format) throws FileNotFoundException {
        libraryIO.printBookList(inventory, format);
    }

    public void welcomeMessage() {
        libraryIO.welcomeMessage("Welcome to Biblioteca!");
    }

    public boolean mainMenu() throws FileNotFoundException {
        int choice = libraryIO.mainMenu();
        return execute(choice);
    }

    boolean execute(int choice) throws FileNotFoundException {
        if (choice == 1) {
            libraryIO.printBookList(inventory, "%30s %30s %30s\n");
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
}
