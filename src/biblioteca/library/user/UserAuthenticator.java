package biblioteca.library.user;

import java.util.List;

public class UserAuthenticator {

    private User currentUser;
    private List<User> users;

    public UserAuthenticator(List<User> users) {
        this.currentUser = User.NO_USER;
        this.users = users;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean login(User user) {
        if (!users.contains(user)) {
            return false;
        }
        currentUser = user;
        return true;
    }

    public boolean loggedIn() {
        return currentUser != User.NO_USER;
    }

    public void logout() {
        currentUser = User.NO_USER;
    }
}
