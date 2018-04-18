package main.java.com.revature.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MasterServlet")
public class MasterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = request.getParameter("destination");

        //setting up redirects
        switch(destination){
            case"directory":
                response.sendRedirect(destination);
                break;
            case"employee":
                response.sendRedirect(destination);
                break;
            default:
                response.sendRedirect("home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
        rd.forward(request,response);
    }
}
