package com.demo;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "validationServlet", urlPatterns = {"/validation.do"})
public class ValidationServlet extends HttpServlet {
    Connection dbconn = null;

    public void init() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql:///webstore";
        String username = "root";
        String password = "yk20010924yk";

        try {
            Class.forName(driver);
            dbconn = DriverManager.getConnection(dburl, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");

        String message="该邮箱可以被使用";
        String myeamil = request.getParameter("myemail");
        String sql = "select * from emailtab where email=?";
        try {
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,myeamil);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()){
                message="邮箱已被使用，请更换其他邮箱!";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //向客户发送xml响应数据
        PrintWriter out = response.getWriter();
        out.println("<response>");
        out.println("<message>"+message+"</message>");
        out.println("</response>");
    }
}
