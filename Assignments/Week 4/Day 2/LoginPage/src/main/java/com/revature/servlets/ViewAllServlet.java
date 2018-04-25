package com.revature.servlets;

import com.revature.POJO.Reimbursement;
import com.revature.Services.ReimbursementService;
import com.revature.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ViewAllServlet extends HttpServlet {

    private static ReimbursementService reimbursementService = new ReimbursementService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper om = new ObjectMapper();
        String s = "";
        PrintWriter pw = response.getWriter();
        ArrayList<Reimbursement> reimbursements = reimbursementService.getAllReimbursement();
        s = om.writeValueAsString(reimbursements);
        pw.write(s);
    }
}
