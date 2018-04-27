package dao;

import pojo.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAO {
    public boolean addReimbursement(double amount, String description, int type, int userid);
    public ArrayList<Reimbursement> getAllReimbursement();
    public ArrayList<Reimbursement> employeeReimbursement(int userid);
    public boolean updateReimbursement(Reimbursement reimbursement);
    

}
