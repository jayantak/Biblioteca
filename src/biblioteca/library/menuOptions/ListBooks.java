package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Lendable;

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
        for (Lendable lendable : library.available()) {
            if (lendable.getClass() != Book.class) {
                continue;
            }
            toPrint.add(lendable);
        }

        userIO.printList(toPrint, "%50s %30s %15s\n");
        return true;
    }

    @Override
    public String toString() {
        return "List Books";
    }
}
