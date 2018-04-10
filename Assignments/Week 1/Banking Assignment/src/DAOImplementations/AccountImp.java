package DAOImplementations;

import DAOs.AccountDAO;
import Util.ConnectionFactory;
import pojos.Account;
import pojos.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountImp implements AccountDAO {
    /*
    public void addAccount(Account newAccount){

        System.out.println("yo");

        User user = new User();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO accounts(userid, balance) VALUES(?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newAccount.getUsername());
            pstmt.setString(2, newAccount.getPassword());


            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    */

    @Override
    public Account getAccountByID(int id) {
        Account account = new Account();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM accounts WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                account.setBalance(rs.getFloat("balance"));
                account.setUserID(rs.getInt("userid"));
                account.setID(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void addAccount(User user) {

        Account account = new Account();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO accounts(userid, balance) VALUES(?,0)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getID());


            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new account was successfully created for you!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAccount(Account oldAccount) {

    }

    @Override
    public ArrayList<Account> getAllUserAccounts(User user) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM accounts WHERE userid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getID());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setBalance(rs.getFloat("balance"));
                account.setUserID(rs.getInt("userid"));
                account.setID(rs.getInt("id"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account updateAccount(Account newInfo) {
        Account account = new Account();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "UPDATE accounts SET userid = ?, balance = ? WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(3, newInfo.getID());
            pstmt.setInt(1, newInfo.getUserID());
            pstmt.setFloat(2, newInfo.getBalance());


            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Transaction successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
