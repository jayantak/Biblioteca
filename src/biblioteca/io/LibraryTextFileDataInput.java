package biblioteca.io;

import biblioteca.library.Book;
import biblioteca.library.LendableList;
import biblioteca.library.Movie;

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

    public LendableList getBookList() {
        LendableList lendableList = new LendableList();
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
            if (metaData.length == 3) {
                lendableList.add(new Book(metaData[0], metaData[1], Integer.parseInt(metaData[2])));
            }
            if (metaData.length == 4) {
                lendableList.add(new Movie(metaData[0], metaData[1], Integer.parseInt(metaData[2]), Integer.parseInt(metaData[3])));
            }
        }
        return lendableList;
    }

}