package com.revature.Services;

import com.revature.DAO.UserDAO;
import com.revature.DAOImp.UserDAOImp;
import com.revature.POJO.User;

public class UserService {
    public static UserDAO userServ = new UserDAOImp();


    public User getUserFromLogin(String user, String pass){
        return userServ.getUser(user, pass);

    }
}
