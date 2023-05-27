package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/guess-number")
public class GuessNumberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        得到用户猜到的数
        int guess = Integer.parseInt(request.getParameter("guess"));
        HttpSession session = request.getSession();
//        从会话对象中取出随机生成的数
        Integer magic = (Integer) session.getAttribute("num");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        if (guess == magic) {
            session.invalidate();//销毁会话对象
            writer.println("祝贺你,答对了!");
            writer.println("<a href = 'guess-number'>再猜一次。</a>");
        } else if (guess > magic) {
            writer.println("太大了! 请重猜!");
        } else {
            writer.println("太小了！请重猜!");
        }
        writer.println("<form action='guess-number' method='post'>");
        writer.println("<input type='text' name='guess'/>");
        writer.println("<input type='submit' value='确定'/>");
        writer.println("</form>");
        writer.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int magic = (int) (Math.random() * 101);
        HttpSession session = request.getSession();
//        将随机生成的数存储到会话对象中
        session.setAttribute("num",new Integer(magic));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("我想出一个0到100之间的数,请你猜!");
        writer.println("<form action='guess-number' method='post'");
        writer.println("<input type='text' name='guess'/>");
        writer.println("<input type='submit' value='确定'/>");
        writer.println("</form>");
        writer.println("</body></html>");

    }
}
