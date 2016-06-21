package biblioteca.library.user;

public class User {

    public static final User NO_USER = new User("", "", "", "", "");
    private final String id;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;

    public User(String id, String password, String name, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(String id, String password) {
        this(id, password, "", "", "");
    }

    @Override
    public String toString() {
        return "Name\t=\t" + name +
                "\nEmail\t=\t" + email +
                "\nPhone\t=\t" + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }
}
