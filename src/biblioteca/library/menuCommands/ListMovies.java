package biblioteca.library.menuCommands;

import biblioteca.io.UserIO;
import biblioteca.library.Lendable;
import biblioteca.library.LendableList;
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
        LendableList toPrint = new LendableList();
        for (Lendable lendable : library.available()) {
            if (lendable.getClass() != Movie.class) {
                continue;
            }
            toPrint.add(lendable);
        }

        userIO.printList(toPrint, "%50s %30s %15s %15s\n");
        return true;
    }

    @Override
    public String toString() {
        return "List Movies";
    }
}
