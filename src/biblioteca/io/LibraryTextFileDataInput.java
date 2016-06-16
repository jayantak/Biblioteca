package biblioteca.io;

import biblioteca.library.Book;
import biblioteca.library.BookList;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Understands input of books from file
public class LibraryTextFileDataInput implements LibraryDataInput {

    private BufferedReader bufferedReader;

    public LibraryTextFileDataInput(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public BookList getBookList() {
        BookList bookList = new BookList();
        List<String> bookListStrings = new ArrayList<>();
        String readLine;
        try {
            while ((readLine = bufferedReader.readLine()) != null) {
                bookListStrings.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String bookData : bookListStrings) {
            String[] metaData = bookData.split(",");
            bookList.add(new Book(metaData[0], metaData[1], Integer.parseInt(metaData[2])));
        }
        return bookList;
    }

}