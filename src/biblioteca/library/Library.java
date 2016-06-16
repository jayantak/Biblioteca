package biblioteca.library;

//Understands lending and returning of books
public class Library {

    private BookList available;
    private BookList checkedOut;

    public Library(BookList available, BookList checkedOut) {
        this.available = available;
        this.checkedOut = checkedOut;
    }

    void checkoutBook(Book foundBook) {
        available.move(checkedOut, foundBook);
    }

    Book getAvailableBookByName(String bookTitle) {
        return available.findBookByName(bookTitle);
    }

    void returnBook(Book foundBook) {
        checkedOut.move(available, foundBook);
    }

    Book getCheckedOutBookByName(String bookTitle) {
        return checkedOut.findBookByName(bookTitle);
    }

    public BookList available() {
        return available;
    }
}
