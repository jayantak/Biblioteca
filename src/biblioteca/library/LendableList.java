package biblioteca.library;

import biblioteca.library.lendableItems.Lendable;

import java.util.ArrayList;

//Understands manipulation of a set of books
public class LendableList extends ArrayList<Lendable> {

    Lendable findByName(String name) {
        for (Lendable lendable : this) {
            if (lendable.hasSameName(name)) {
                return lendable;
            }
        }
        return null;
    }

    void move(LendableList other, Lendable lendable) {
        this.remove(lendable);
        other.add(lendable);
    }
}
