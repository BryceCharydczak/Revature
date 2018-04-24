package com.revature.DAOImp;

import com.revature.DAO.UserDAO;
import com.revature.POJO.User;
import com.revature.Util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImp implements UserDAO {

    @Override
    public User getUser(String username, String password) {
        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM Users WHERE ers_username = ? AND ers_password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                User temp = new User();
                temp.setUserID(rs.getInt(1));
                temp.setUsername((rs.getString(2));
                temp.setFirstname(rs.getString(4));
                temp.setLastname(rs.getString(5));
                temp.setEmail(rs.getString(6));
                temp.setRoleID(rs.getInt(7));
                return temp;
            }
            else {
                System.out.println("can't find user!!!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

