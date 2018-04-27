package servlet;

import pojo.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginServlet(){
        super();
    }

    private static UserService usr = new UserService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
        System.out.println("hi");
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);


        User user = usr.getUserFromLogin(username, password);
        session.setAttribute("currentuser", user);

        if (user == null){
            System.out.println("null");
        }
        System.out.println(user.getRoleID());

        if (user.getRoleID()==0){
            response.sendRedirect("admin");
        } else if (user.getRoleID()==1){
        	response.sendRedirect("request");
        }else {
            response.sendRedirect("login");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rq = request.getRequestDispatcher("Views/login.html");
        rq.forward(request,response);
    }
}
