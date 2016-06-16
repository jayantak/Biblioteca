package biblioteca.library;

//Understands lending and returning of books
public class Library {

    private LendableList available;
    private LendableList checkedOut;

    public Library(LendableList available, LendableList checkedOut) {
        this.available = available;
        this.checkedOut = checkedOut;
    }

    public void checkoutBook(Lendable foundLendable) {
        available.move(checkedOut, foundLendable);
    }

    public Lendable getAvailableBookByName(String bookTitle) {
        return available.findByName(bookTitle);
    }

    public void returnBook(Lendable foundLendable) {
        checkedOut.move(available, foundLendable);
    }

    public Lendable getCheckedOutBookByName(String bookTitle) {
        return checkedOut.findByName(bookTitle);
    }

    public LendableList available() {
        return available;
    }
}
