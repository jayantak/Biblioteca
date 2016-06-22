package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.user.UserAuthenticator;

public class UserDetails implements MenuOption {

    private UserIO userIO;
    private UserAuthenticator userAuthenticator;

    public UserDetails(UserIO userIO, UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
        this.userIO = userIO;
    }

    @Override
    public boolean accessAvailable() {
        return userAuthenticator.loggedIn();
    }

    @Override
    public boolean run() {
        userIO.display(userAuthenticator.getCurrentUser().toString());
        return true;
    }

    @Override
    public String toString() {
        return "User Details";
    }
}
