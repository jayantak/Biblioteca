package biblioteca.library;

import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.user.User;

//Understands lending and returning of books
public class Library {

    private LendableList inventory;
    private LendableList checkedOut;

    public Library(LendableList inventory, LendableList checkedOut) {
        this.inventory = inventory;
        this.checkedOut = checkedOut;
    }

    public void checkoutLendable(Lendable foundLendable, User user) {
        inventory.move(checkedOut, foundLendable, user);
    }

    public Lendable getAvailableBookByName(String bookTitle) {
        Lendable found = inventory.findByName(bookTitle);
        if (found.getClass() != Book.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }

    public void returnLendable(Lendable foundLendable, User user) {
        checkedOut.move(inventory, foundLendable, user);
    }

    public Lendable getCheckedOutBookByName(String bookTitle) {
        Lendable found = checkedOut.findByName(bookTitle);
        if (found.getClass() != Book.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }

    public LendableList available() {
        return inventory;
    }

    public Lendable getCheckedOutMovieByName(String title) {
        Lendable found = checkedOut.findByName(title);
        if (found.getClass() != Movie.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }

    public Lendable getAvailableMovieByName(String bookTitle) {
        Lendable found = inventory.findByName(bookTitle);
        if (found.getClass() != Movie.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }
}
