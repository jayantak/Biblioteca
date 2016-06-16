package biblioteca.library.menuCommands;

import biblioteca.io.UserIO;
import biblioteca.library.Book;
import biblioteca.library.Library;

//Understands how to checkout a book
public class CheckoutBook implements LibraryFunction {

    private UserIO userIO;
    private Library library;

    public CheckoutBook(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of book to checkout: ");
        String bookTitle = userIO.inputBookTitle();
        Book foundBook = library.getCheckedOutBookByName(bookTitle);
        if (foundBook != null) {
            userIO.display("Sorry that book is checked out!");
            return true;
        }
        foundBook = library.getAvailableBookByName(bookTitle);
        if (foundBook != null) {
            library.checkoutBook(foundBook);
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
