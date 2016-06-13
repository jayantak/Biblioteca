package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Understands input of books from file
public class TextFileDataInput implements LibraryDataInput {

    String path;

    public TextFileDataInput(String path) {
        this.path = path;
    }

    public BookList getBookList() throws FileNotFoundException {
        BookList bookList = new BookList();
        String bookListString = getBookListString();
        String[] bookListData = bookListString.split("\n");
        for (String bookData : bookListData) {
            bookList.add(createBook(bookData));
        }
        return bookList;
    }

    private String getBookListString() throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + "/" + path + "/libraryInventory.books";
        File file = new File(pathname);
        Scanner scanner = new Scanner(file).useDelimiter("\\Z");
        return scanner.next();
    }

    Book createBook(String bookData) {
        String[] metaData = bookData.split(",");
        return new Book(metaData[0], metaData[1], Integer.parseInt(metaData[2]));
    }
}