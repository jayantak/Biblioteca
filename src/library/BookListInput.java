package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class BookListInput {

    String path;

    public BookListInput(String path) {
        this.path = path;
    }

    public void populateFrom(BookList bookList) throws FileNotFoundException {
        String bookListString = getBookListString();
        String[] bookListData = bookListString.split("\n");
        for (String bookData : bookListData) {
            bookList.add(Book.createBook(bookData));
        }
    }

    private String getBookListString() throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + "/" + path + "/libraryInventory.books";
        File file = new File(pathname);
        Scanner scanner = new Scanner(file).useDelimiter("\\Z");
        return scanner.next();
    }
}