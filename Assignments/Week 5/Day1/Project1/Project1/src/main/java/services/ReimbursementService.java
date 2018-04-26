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
}
