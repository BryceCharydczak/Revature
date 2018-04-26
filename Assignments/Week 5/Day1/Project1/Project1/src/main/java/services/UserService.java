package services;

import dao.UserDAO;
import dao.UserDAOImp;
import pojo.User;

public class UserService {
    public static UserDAO userServ = new UserDAOImp();


    public User getUserFromLogin(String user, String pass){
        return userServ.getUser(user, pass);

    }
}
