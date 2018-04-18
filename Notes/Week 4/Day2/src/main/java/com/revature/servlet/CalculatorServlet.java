package main.java.com.revature.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {



    private static final long serialVersionUID = 1L;

    public CalculatorServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        //pw.write("Performed get request in Calculator servlet");
        //pw.write("<p>The calculator page is</p><br><a href=");
        RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
        rd.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String operation = request.getParameter("operation");
        String answer = "";

        try{
            Integer a = Integer.parseInt(n1);
            Integer b = Integer.parseInt(n2);
            switch(operation){
                case "add":
                    answer = Integer.toString(a+b);
                    break;
                case "subtract":
                    answer = Integer.toString(a-b);
                    break;
                case "multiply":
                    answer = Integer.toString(a*b);
                    break;
                case "divide":
                    answer = Integer.toString(a/b);
                    break;
                default:
                    answer = "invalid operation";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        //PrintWriter pw = response.getWriter();
        //pw.write("<p>The answer is : " + answer);
        //pw.write("<br><a href=");
        request.setAttribute("answer",answer);
        RequestDispatcher rd = request.getRequestDispatcher("answer");
    }


}
