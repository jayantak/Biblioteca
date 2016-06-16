package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Understands input of books from file
public class LibraryTextFileDataInput implements LibraryDataInput {

    String path;

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

        }
        String bookListString = scanner.next();
        String[] bookListData = bookListString.split("\n");
        for (String bookData : bookListData) {
            String[] metaData = bookData.split(",");
            bookList.add(new Book(metaData[0], metaData[1], Integer.parseInt(metaData[2])));
        }
        return bookList;
    }

}