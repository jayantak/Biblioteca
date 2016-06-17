package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.UserAuthenticator;

//Understands how to checkoutLendable a book
public class CheckoutBook implements MenuOption {

    private UserIO userIO;
    private Library library;
    private UserAuthenticator userAuthenticator;

    public CheckoutBook(UserIO userIO, Library library, UserAuthenticator userAuthenticator) {
        this.userIO = userIO;
        this.library = library;
        this.userAuthenticator = userAuthenticator;
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of book to checkoutLendable: ");
        String bookTitle = userIO.inputLine();
        Lendable foundBook = library.getCheckedOutBookByName(bookTitle);
        if (foundBook != null) {
            userIO.display("Sorry that book is checked out!");
            return true;
        }
        foundBook = library.getAvailableBookByName(bookTitle);
        if (foundBook != null) {
            library.checkoutLendable(foundBook, userAuthenticator.getCurrentUser());
            userIO.display("Thank you! Enjoy the book!");
            return true;
        }
        userIO.display("Sorry that book does not exist!");
        return true;
    }

    @Override
    public String toString() {
        return "Checkout Book";
    }
}
