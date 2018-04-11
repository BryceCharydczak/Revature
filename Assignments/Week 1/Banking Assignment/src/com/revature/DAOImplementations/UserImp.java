package com.revature.DAOImplementations;

import com.revature.DAOs.UserDAO;
import com.revature.Util.ConnectionFactory;
import com.revature.pojos.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserImp implements UserDAO {

    @Override
    public void addUser(User newUser) {
        User user = new User();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO users(username, pass) VALUES(?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());


            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getUserByUser(User user) {
        User user2 = new User();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user2.setPassword(rs.getString("pass"));
                user2.setUsername(rs.getString("username"));
                user2.setID(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user2;
    }

    @Override
    public void removeUserByID(int oldUserID) {

    }

    @Override
    public User updateUser(User newInfo) {
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setPassword(rs.getString("pass"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
