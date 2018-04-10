package pojos;

import java.util.Objects;

public class User {
    private int ID;
    private String Username;
    private String Password;

    public User(int ID, String username, String password) {
        this.ID = ID;
        Username = username;
        Password = password;
    }

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID &&
                Objects.equals(Username, user.Username) &&
                Objects.equals(Password, user.Password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, Username, Password);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
