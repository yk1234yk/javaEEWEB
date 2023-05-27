package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = "/first_servlet")
public class FirstServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        Student student = new Student(sno, sname);
        request.setAttribute("student",student);
        RequestDispatcher rd = request.getRequestDispatcher("/second-servlet");
        rd.forward(request,response);
    }
}
