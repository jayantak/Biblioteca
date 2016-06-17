package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.lendableItems.Movie;

public class ListMovies implements MenuOption {

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
