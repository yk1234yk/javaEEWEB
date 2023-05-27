package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "examServlet", urlPatterns = "/exam-servlet")
public class ExamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String quest1 = request.getParameter("q1");
        String quest2 = request.getParameter("q2").trim();
        String[] quest3 = request.getParameterValues("q3");
        String quest4 = request.getParameter("q4").trim();
        int score = 0;
        if (quest1 != null && quest1.equals("3")) {
            score = score + 25;//答对加25分
        }
        if (quest2.equals("HttpServlet") || quest2.equals("javax.servlet.http.HttpServlet")) {
            score = score + 25;
        }
        if (quest3 != null && quest3.length == 2 && quest3[0].equals("1") && quest3[1].equals("3")) {
            score = score + 25;
        }
        if (quest4.equals("3")) {
            score = score + 25;
        }
        writer.println("<html><head>");
        writer.println("<title>测试结果</title>");
        writer.println("</head><body>");
        writer.println("你的成绩是: " + score + "分");
        writer.println("</body><html>");
    }
}
