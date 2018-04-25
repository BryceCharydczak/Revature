package com.revature.DAOImp;

import com.revature.DAO.UserDAO;
import com.revature.POJO.User;
import com.revature.Util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDAOImp implements UserDAO {

    @Override
    public User getUser(String username, String password) {
        User temp = new User();

        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                temp.setUserID(rs.getInt(1));
                temp.setUsername((rs.getString(2)));
                temp.setPassword(rs.getString(3));
                temp.setFirstname(rs.getString(4));
                temp.setLastname(rs.getString(5));
                temp.setEmail(rs.getString(6));
                temp.setRoleID(rs.getInt(7));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (temp != null){
            return temp;
        } else {
            return null;
        }
    }

}

