import java.util.ArrayList;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImp;
import pojo.Reimbursement;

public class Driver {

	public static void main(String args[]) {
		ReimbursementDAO te = new ReimbursementDAOImp();
		te.addReimbursement(1000, "poop", 2, 1);
	}
}
