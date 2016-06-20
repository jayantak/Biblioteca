package biblioteca.library.lendableItems;

public interface Lendable {

    Lendable NO_LENDABLE = new Lendable() {
        @Override
        public String toString(String format) {
            return "NO LENDABLE ITEM FOUND";
        }

        @Override
        public boolean hasSameName(String otherName) {
            return false;
        }
    };

    String toString(String format);

    boolean hasSameName(String otherName);
}
