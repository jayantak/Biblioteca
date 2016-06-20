package biblioteca.io;

import biblioteca.library.user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Understands input of books from file
public class LibraryTextFileUsersInput {

    private BufferedReader bufferedReader;

    public LibraryTextFileUsersInput(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        List<String> userListString = new ArrayList<>();
        String readLine;
        try {
            while ((readLine = bufferedReader.readLine()) != null) {
                userListString.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String data : userListString) {
            String[] metaData = data.split(",");
                users.add(new User(metaData[0], metaData[1], metaData[2], metaData[3], metaData[4]));
        }
        return users;
    }
}