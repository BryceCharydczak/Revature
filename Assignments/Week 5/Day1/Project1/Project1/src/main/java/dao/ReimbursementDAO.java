package dao;

import pojo.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAO {
    public void addReimbursement(Reimbursement reimbursement);
    public ArrayList<Reimbursement> getAllReimbursement();

}
