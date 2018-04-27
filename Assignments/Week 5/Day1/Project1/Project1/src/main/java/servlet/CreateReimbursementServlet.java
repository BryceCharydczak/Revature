package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import services.ReimbursementService;

/**
 * Servlet implementation class CreateReimbursementServlet
 */
public class CreateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService rs = new ReimbursementService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rq = request.getRequestDispatcher("Views/createReimburse.html");
        rq.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
			if(session != null && session.getAttribute("currentuser") != null) {
			User temp = (User) session.getAttribute("currentuser");
			double amount = Double.parseDouble(request.getParameter("amount"));
			String description = request.getParameter("description");
			int type =0;
			switch (request.getParameter("type")){
				case "LODGING":
					type = 0;
					break;
				case "TRAVEL":
					type= 1;
					break;
				case "FOOD":
					type = 2;
					break;
				case "OTHER":
					type=3;
					break;
				default:
			}


			int id = temp.getUserID();

			rs.addReimbursement(amount, description, type, id);

	}
			doGet(request,response);
	}
}




