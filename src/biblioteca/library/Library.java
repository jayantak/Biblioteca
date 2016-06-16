package biblioteca.library;

//Understands lending and returning of books
public class Library {

    private BookList available;
    private BookList checkedOut;

    public Library(BookList available, BookList checkedOut) {
        this.available = available;
        this.checkedOut = checkedOut;
    }

    public void checkoutBook(Book foundBook) {
        available.move(checkedOut, foundBook);
    }

    public Book getAvailableBookByName(String bookTitle) {
        return available.findBookByName(bookTitle);
    }

    public void returnBook(Book foundBook) {
        checkedOut.move(available, foundBook);
    }

    public Book getCheckedOutBookByName(String bookTitle) {
        return checkedOut.findBookByName(bookTitle);
    }

    public BookList available() {
        return available;
    }
}
