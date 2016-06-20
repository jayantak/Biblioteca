package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.user.User;

import java.util.Map;

public class ListMovies implements MenuOption {

    private UserIO userIO;
    private Library library;

    public ListMovies(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    public boolean accessRestricted() {
        return true;
    }

    @Override
    public boolean run() {
        LendableList toPrint = new LendableList();
        for (Map.Entry<Lendable, User> lendable : library.available().entrySet()) {
            if (lendable.getKey().getClass() != Movie.class) {
                continue;
            }
            if (lendable.getValue() != User.NO_USER) {
                continue;
            }
            toPrint.put(lendable.getKey(), User.NO_USER);
        }

        userIO.printList(toPrint, "%50s %30s %15s %15s\n");
        return true;
    }

    @Override
    public String toString() {
        return "List Movies";
    }
}
