package dao;

import dao.ReimbursementDAO;
import pojo.Reimbursement;
import util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReimbursementDAOImp implements ReimbursementDAO {
    public boolean addReimbursement(double amount, String description, int type, int userid) {
    	
    	try {
			Connection conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO reimbursement (reimb_amount,reimb_submitted,reimb_description,reimb_author,reimb_status_id,reimb_type_id) VALUES (?,CURRENT_TIMESTAMP,?,?,'2',?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			pstmt.setString(2, description);
			pstmt.setInt(3, userid);
			pstmt.setInt(4, type);
			pstmt.executeQuery();
			conn.commit();
			return true;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return false;
    }
    

    
    public ArrayList<Reimbursement> getAllReimbursement() {
        ArrayList<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM REIMBURSEMENT";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Reimbursement re = new Reimbursement();
                re.setReimbursementID(rs.getInt(1));
                re.setAmount(rs.getDouble(2));
                re.setSubTime(rs.getString(3));
                re.setResTime(rs.getString(4));
                re.setDescription(rs.getString(5));
                re.setAuthor(rs.getInt(7));
                re.setStatusID(rs.getInt(9));
                re.setTypeID(rs.getInt(10));
                
                allReimbursements.add(re);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return allReimbursements;
    }
    public ArrayList<Reimbursement> getEmployeeReimbursement() {
        ArrayList<Reimbursement> employeeReimbursements = new ArrayList<Reimbursement>();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM REIMBURSEMENT";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Reimbursement re = new Reimbursement();
                re.setReimbursementID(rs.getInt(1));
                re.setAmount(rs.getDouble(2));
                re.setSubTime(rs.getString(3));
                re.setResTime(rs.getString(4));
                re.setDescription(rs.getString(5));
                re.setAuthor(rs.getInt(7));
                re.setStatusID(rs.getInt(9));
                re.setTypeID(rs.getInt(10));
            }

        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return employeeReimbursements;
    }



	public boolean updateReimbursement(Reimbursement reimbursement) {
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENT SET REIMB_STATUS_ID = ?, REIMB_RESOLVED = CURRENT_TIMESTAMP WHERE reimb_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimbursement.getStatusID());
			pstmt.setInt(2, reimbursement.getReimbursementID());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	public ArrayList<Reimbursement> employeeReimbursement(int userid){
		ArrayList<Reimbursement> employeeReimbursements = new ArrayList<Reimbursement>();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery(sql);
            while(rs.next()){
                Reimbursement re = new Reimbursement();
                re.setReimbursementID(rs.getInt(1));
                re.setAmount(rs.getDouble(2));
                re.setSubTime(rs.getString(3));
                re.setResTime(rs.getString(4));
                re.setDescription(rs.getString(5));
                re.setAuthor(rs.getInt(7));
                re.setStatusID(rs.getInt(9));
                re.setTypeID(rs.getInt(10));
                employeeReimbursements.add(re);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return employeeReimbursements;
	}
}
