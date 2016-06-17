package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.User;

//Understands how to list the books
public class ListBooks implements MenuOption {

    private UserIO userIO;
    private Library library;

    public ListBooks(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    @Override
    public boolean run() {
        LendableList toPrint = new LendableList();
        for (Lendable lendable : library.available().keySet()) {
            if (lendable.getClass() != Book.class) {
                continue;
            }
            toPrint.put(lendable, User.NO_USER);
        }

        userIO.printList(toPrint, "%50s %30s %15s\n");
        return true;
    }

    @Override
    public String toString() {
        return "List Books";
    }
}
