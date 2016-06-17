package biblioteca.library;

import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.user.User;

//Understands lending and returning of books
public class Library {

    private LendableList available;
    private LendableList checkedOut;

    public Library(LendableList available, LendableList checkedOut) {
        this.available = available;
        this.checkedOut = checkedOut;
    }

    public void checkoutLendable(Lendable foundLendable, User user) {
        available.move(checkedOut, foundLendable, user);
    }

    public Lendable getAvailableBookByName(String bookTitle) {
        Lendable found = available.findByName(bookTitle);
        if (found.getClass() != Book.class) {
            return null;
        }
        return found;
    }

    public void returnLendable(Lendable foundLendable, User user) {
        checkedOut.move(available, foundLendable, user);
    }

    public Lendable getCheckedOutBookByName(String bookTitle) {
        Lendable found = checkedOut.findByName(bookTitle);
        if (found.getClass() != Book.class) {
            return null;
        }
        return found;
    }

    public LendableList available() {
        return available;
    }

    public Lendable getCheckedOutMovieByName(String title) {
        Lendable found = checkedOut.findByName(title);
        if (found.getClass() != Movie.class) {
            return null;
        }
        return found;
    }

    public Lendable getAvailableMovieByName(String bookTitle) {
        Lendable found = available.findByName(bookTitle);
        if (found.getClass() != Movie.class) {
            return null;
        }
        return found;
    }
}
