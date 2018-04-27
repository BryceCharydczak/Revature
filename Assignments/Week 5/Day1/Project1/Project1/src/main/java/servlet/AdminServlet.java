package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReimbursementDAOImp;
import pojo.Reimbursement;
import services.ReimbursementService;
import services.UserService;

import java.io.IOException;

public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static ReimbursementService rem = new ReimbursementService();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String decision = request.getParameter("decision");
        Reimbursement re = new Reimbursement();
        if (decision.contains(".")) {
        	re.setStatusID(0);
        	String[] temp = decision.split("\\.");
        	String temp2 = temp[0];
        	re.setReimbursementID(Integer.parseInt(temp2));
        	rem.updateReimbursement(re);
        } else {
        	re.setStatusID(1);
        	re.setReimbursementID(Integer.parseInt(decision));
        	rem.updateReimbursement(re);
        }
    	//System.out.println(decision);
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("Views/all.html");
        rq.forward(request,response);
    }
}
