package biblioteca.library.menuOptions;

import biblioteca.library.user.UserAuthenticator;

public class LogOut implements MenuOption {

    private UserAuthenticator userAuthenticator;

    public LogOut(UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }

    @Override
    public boolean accessRestricted() {
        return false;
    }

    @Override
    public boolean run() {
        userAuthenticator.logout();
        return true;
    }


    @Override
    public String toString() {
        return "Log Out";
    }
}
