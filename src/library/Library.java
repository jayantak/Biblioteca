package library;

import java.io.FileNotFoundException;

//Understands lending of books
public class Library {

    private BookList inventory;

    public Library(BookList bookList) {
        inventory = bookList;
    }

    public Library() {
        this(new BookList());
    }

    public BookList bookList() throws FileNotFoundException {
        return inventory;
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
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
