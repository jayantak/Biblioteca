package biblioteca.library;

import biblioteca.io.UserIO;

//Understands lending of books
public class Library {

    private BookList available;
    private UserIO userIO;
    private BookList checkedOut;

    public Library(BookList available, UserIO userIO, BookList checkedOut) {
        this.available = available;
        this.userIO = userIO;
        this.checkedOut = checkedOut;
    }

    public Library(BookList available, UserIO userIO) {
        this(available, userIO, new BookList());
    }

    boolean execute(int choice) {
        if (choice == 1) {
            userIO.printBookList(available, "%50s %30s %15s\n");
            return true;
        }
        if (choice == 0) {
            return false;
        }
        if (choice == 2) {
            checkout();
            return true;
        }
        if (choice == 3) {
            returnBook();
            return true;
        }
        userIO.invalidOption();
        return true;
    }

    @Override
    public String toString() {
        return "Library{" +
                "available=" + available +
                ", userIO=" + userIO +
                ", checkedOut=" + checkedOut +
                '}';
    }

    private void checkout() {
        userIO.display("Enter title of book to checkout: ");
        String bookTitle = userIO.inputBookTitle();
        Book foundBook = available.findBookByName(bookTitle);
        if (foundBook != null) {
            available.move(checkedOut, foundBook);
            userIO.display("Thank you! Enjoy the book!");
            return;
        }
        foundBook = checkedOut.findBookByName(bookTitle);
        if (foundBook != null) {
            userIO.display("Sorry that book is checked out!");
            return;
        }
        userIO.display("Sorry that book does not exist!");
    }

    private void returnBook() {
        userIO.display("Enter title of book to return: ");
        String bookTitle = userIO.inputBookTitle();
        Book foundBook = checkedOut.findBookByName(bookTitle);
        if (foundBook != null) {
            checkedOut.remove(foundBook);
            available.add(foundBook);
            userIO.display("Thank you for returning the book!");
        }
        foundBook = available.findBookByName(bookTitle);
        if (foundBook != null) {
            userIO.display("That book has not been checked out!");
            return;
        }
        userIO.display("Sorry that book does not exist!");
    }
}
