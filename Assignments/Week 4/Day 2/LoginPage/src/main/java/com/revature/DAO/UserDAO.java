package com.revature.DAO;

import com.revature.POJO.User;

import java.util.ArrayList;

public interface UserDAO {

    public User getUser(String username, String password);
}
