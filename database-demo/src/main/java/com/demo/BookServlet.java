package com.demo;

import com.domain.Book;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/add-book")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    Connection conn = null;
    DataSource dataSource;

    @Override
    public void init() {
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String dburl = "jdbc:mysql://127.0.0.1:3306/webstore?useSSL=true";
//        String user = "root";
//        String password = "yk20010924yk";
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(dburl, user, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            getServletContext().log("驱动程序找不到!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            ComboPooledDataSource c3p0 = new ComboPooledDataSource("c3p0");
            conn = c3p0.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        float price = Float.parseFloat(request.getParameter("price"));
        String delete = request.getParameter("delete");
        String messageOne = "";
        String messageTwo = "";
        try {
            int num = bookService.addBook(new Book(isbn, title, price));
            int deleteBook = bookService.deleteBook(delete);
//            String sql = "insert into books values(?,?,?)";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, isbn);
//            statement.setString(2, title);
//            statement.setFloat(3, price);
//
//            int num = statement.executeUpdate();
            if (num == 1) {
                messageOne = "插入记录成功!";
            } else {
                messageOne = "插入记录失败";
            }
            if (deleteBook == 1) {
                messageTwo = "删除记录成功!";
            } else {
                messageTwo = "删除记录失败";
            }
            request.setAttribute("messageOne", messageOne);
            request.setAttribute("messageTwo", messageTwo);
            request.getRequestDispatcher("add-book.jsp").forward(request, response);
        } catch (Exception e) {
            messageOne = e.getMessage();
            messageTwo = e.getMessage();
            request.setAttribute("messageOne", messageOne);
            request.setAttribute("messageTwo", messageTwo);
            request.getRequestDispatcher("add-book.jsp").forward(request, response);

        }
    }
}
