package library;

import java.io.FileNotFoundException;

//Understands lending of books
public class Library {

    private BookList inventory;

    private Library() {
        inventory = new BookList();
    }

    public static Library createLibrary(String libraryName) throws FileNotFoundException {
        Library library = new Library();
        library.inventory.populateFrom(libraryName);
        return library;
    }

    public static Library createLibrary(BookList bookList)  {
        Library library = new Library();
        library.inventory = bookList;
        return library;
    }

    public BookList bookList() throws FileNotFoundException {
        return inventory;
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
