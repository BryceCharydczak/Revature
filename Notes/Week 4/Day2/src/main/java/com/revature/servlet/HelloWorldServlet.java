package main.java.com.revature.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
        System.out.println("Service method was called");
        PrintWriter pw = res.getWriter();
        pw.println("hello world");

    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method was called");
    }

    public void destroy(){
        System.out.println("Destroy method was called");
    }
}
