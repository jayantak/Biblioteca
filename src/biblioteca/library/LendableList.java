package biblioteca.library;

import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.User;

import java.util.HashMap;
import java.util.Map;

//Understands manipulation of a set of books
public class LendableList extends HashMap<Lendable, User> {

    Lendable findByName(String name, User user) {
        for (Map.Entry<Lendable, User> lendable : this.entrySet()) {
            if (lendable.getKey().hasSameName(name) && lendable.getValue().equals(user)) {
                return lendable.getKey();
            }
        }
        return Lendable.NO_LENDABLE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
