package biblioteca.io;

import biblioteca.library.Book;
import biblioteca.library.BookList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static javafx.application.Platform.exit;

//Understands input of books from file
public class LibraryTextFileDataInput implements LibraryDataInput {

    private String path;

    public LibraryTextFileDataInput(String path) {
        this.path = path;
    }

    public BookList getBookList() {
        BookList bookList = new BookList();
        String pathname = System.getProperty("user.dir") + "/" + path + "/libraryInventory.books";
        File file = new File(pathname);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file).useDelimiter("\\Z");
        } catch (FileNotFoundException e) {
            exit();
        }
        String bookListString = null;
        if (scanner != null) {
            bookListString = scanner.next();
        }
        String[] bookListData = bookListString.split("\n");
        for (String bookData : bookListData) {
            String[] metaData = bookData.split(",");
            bookList.add(new Book(metaData[0], metaData[1], Integer.parseInt(metaData[2])));
        }
        return bookList;
    }

}