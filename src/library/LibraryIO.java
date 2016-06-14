package library;

public interface LibraryIO {

    void display(String s);

    void printBookList(BookList bookList, String format);

    int mainMenu();

    void invalidOption();
}
