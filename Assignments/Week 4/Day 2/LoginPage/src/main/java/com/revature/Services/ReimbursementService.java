package com.revature.Services;

import com.revature.DAO.ReimbursementDAO;
import com.revature.DAOImp.ReimbursementDAOImp;
import com.revature.POJO.Reimbursement;

import java.util.ArrayList;

public class ReimbursementService {
    public static ReimbursementDAO rd = new ReimbursementDAOImp();

    public ArrayList<Reimbursement> getAllReimbursement(){
        return rd.getAllReimbursement();
    }
}
