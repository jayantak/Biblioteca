package biblioteca.library.user;

import java.util.List;

public class UserAuthenticator {

    User currentUser;
    List<User> users;

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
}
