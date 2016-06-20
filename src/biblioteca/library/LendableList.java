package biblioteca.library;

import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.User;

import java.util.HashMap;
import java.util.Map;

//Understands manipulation of a set of books
public class LendableList extends HashMap<Lendable, User> {

    Lendable findByName(String name) {
        for (Map.Entry<Lendable, User> lendable : this.entrySet()) {
            if (lendable.getKey().hasSameName(name)) {
                return lendable.getKey();
            }
        }
        return Lendable.NO_LENDABLE;
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
