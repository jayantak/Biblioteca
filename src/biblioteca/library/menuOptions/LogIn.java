package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.user.User;
import biblioteca.library.user.UserAuthenticator;

public class LogIn implements MenuOption {

    private UserIO userIO;
    private UserAuthenticator userAuthenticator;

    public LogIn(UserIO userIO, UserAuthenticator userAuthenticator) {
        this.userIO = userIO;
        this.userAuthenticator = userAuthenticator;
    }

    public boolean accessRestricted() {
        return true;
    }

    @Override
    public boolean run() {
        userIO.display("Enter username:");
        String name = userIO.inputLine();
        userIO.display("Enter password:");
        String password = userIO.inputLine();
        boolean loginSuccessful = userAuthenticator.login(new User(name, password));
        if (!loginSuccessful) {
            userIO.display("Username or password wrong!");
            return true;
        }
        userIO.display("Login successful!");
        return true;
    }

    @Override
    public String toString() {
        return "Log In";
    }
}
