package DAOs;

import pojos.User;

import java.util.ArrayList;

public interface UserDAO {
    public void addUser(User newUser);
    public void removeUserByID(int oldUserID);
    public User updateUser(User newInfo);
    public ArrayList<User> getAllUsers();
    public User getUserByUser(User user);
}
