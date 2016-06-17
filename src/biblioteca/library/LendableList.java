package biblioteca.library;

import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.User;

import java.util.HashMap;

//Understands manipulation of a set of books
public class LendableList extends HashMap<Lendable, User> {

    Lendable findByName(String name) {
        for (Lendable lendable : this.keySet()) {
            if (lendable.hasSameName(name)) {
                return lendable;
            }
        }
        return null;
    }

    void move(LendableList other, Lendable lendable, User user) {
        this.remove(lendable);
        other.put(lendable, user);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
