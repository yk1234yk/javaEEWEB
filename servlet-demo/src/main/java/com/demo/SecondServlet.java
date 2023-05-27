package com.demo;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;


@WebServlet("/second-servlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = (Student) request.getAttribute("student");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("学号: " + student.getSno() + "<br>");
        writer.println("姓名: " + new String(
                student.getName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + "<br>"
        );
        writer.println("<a href='input.jsp'>返回输入界面</a>");
    }
}
