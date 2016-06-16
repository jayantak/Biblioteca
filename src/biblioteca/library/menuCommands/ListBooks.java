package biblioteca.library.menuCommands;

import biblioteca.io.UserIO;
import biblioteca.library.Library;

//Understands how to list the books
public class ListBooks implements LibraryFunction {

    private UserIO userIO;
    private Library library;

    public ListBooks(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    @Override
    public boolean run() {
        userIO.printBookList(library.available(), "%50s %30s %15s\n");
        return true;
    }

    @Override
    public String toString() {
        return "List Books";
    }
}
