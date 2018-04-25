package com.revature.DAO;

import com.revature.POJO.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAO {
    public void addReimbursement(Reimbursement reimbursement);
    public ArrayList<Reimbursement> getAllReimbursement();

}
