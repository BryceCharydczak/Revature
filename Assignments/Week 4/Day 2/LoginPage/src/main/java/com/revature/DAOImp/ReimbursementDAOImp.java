package com.revature.DAOImp;

import com.revature.DAO.ReimbursementDAO;
import com.revature.POJO.Reimbursement;
import com.revature.Util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReimbursementDAOImp implements ReimbursementDAO {
    @Override
    public void addReimbursement(Reimbursement reimbursement) {

    }

    @Override
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
            }

        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return allReimbursements;
    }
}
