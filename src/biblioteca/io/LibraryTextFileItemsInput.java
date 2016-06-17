package biblioteca.io;

import biblioteca.library.LendableList;
import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static biblioteca.library.user.User.NO_USER;

//Understands input of books from file
public class LibraryTextFileItemsInput implements LibraryDataInput {

    private BufferedReader bufferedReader;

    public LibraryTextFileItemsInput(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public LendableList getBookList() {
        LendableList lendableList = new LendableList();
        List<String> lendableListStrings = new ArrayList<>();
        String readLine;
        try {
            while ((readLine = bufferedReader.readLine()) != null) {
                lendableListStrings.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String data : lendableListStrings) {
            String[] metaData = data.split(",");
            if (metaData.length == 3) {
                lendableList.put(new Book(metaData[0], metaData[1], Integer.parseInt(metaData[2])), NO_USER);
            }
            if (metaData.length == 4) {
                lendableList.put(new Movie(metaData[0], metaData[1], Integer.parseInt(metaData[2]), Integer.parseInt(metaData[3])), NO_USER);
            }
        }
        return lendableList;
    }
}