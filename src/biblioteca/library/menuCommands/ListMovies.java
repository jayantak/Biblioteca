package biblioteca.library.menuCommands;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.Movie;

public class ListMovies implements LibraryFunction {

    private UserIO userIO;
    private Library library;

    public ListMovies(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    @Override
    public boolean run() {
        userIO.printList(library.available(), new Movie("", "", 0, 0), "%50s %30s %15s %15s\n");
        return true;
    }

    @Override
    public String toString() {
        return "List Movies";
    }
}
