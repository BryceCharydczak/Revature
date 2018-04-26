package dao;

import pojo.User;

public interface UserDAO {

    public User getUser(String username, String password);
}
