package services;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImp;
import pojo.Reimbursement;

import java.util.ArrayList;

public class ReimbursementService {
    public static ReimbursementDAO rd = new ReimbursementDAOImp();

    public ArrayList<Reimbursement> getAllReimbursement(){
        return rd.getAllReimbursement();
    }
    
    public boolean addReimbursement(double amount, String description, int type, int userid) {
    	return rd.addReimbursement(amount, description, type, userid);
    }
    
	public boolean updateReimbursement(Reimbursement reimbursement) {
		return rd.updateReimbursement(reimbursement);
	}
	
	public ArrayList<Reimbursement> employeeReimbursement(int userid){
		return rd.employeeReimbursement(userid);
	}
}
