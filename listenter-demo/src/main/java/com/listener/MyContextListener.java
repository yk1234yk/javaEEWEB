package com.listener;

import com.demain.Product;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

@WebListener
public class MyContextListener implements ServletContextListener {
    private ServletContext context = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Context ctx = null;
//        DataSource dataSource = null;
        context = sce.getServletContext();
        ArrayList<Product> productList = new ArrayList<>();
//        try {
//            if (ctx == null) {
//                ctx = new InitialContext();
//            }
//            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/westoreDS");
//        } catch (NamingException ne) {
//            context.log("发生异常:" + ne);
//        }
        try {
            ComboPooledDataSource c3p0 = new ComboPooledDataSource("c3p0");
            Connection conn = c3p0.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery("select * from products");
            while (set.next()) {
                Product product = new Product();
                product.setId(set.getInt("id"));
                product.setPname(set.getString("pname"));
                product.setBrand(set.getString("brand"));
                product.setPrice(set.getFloat("price"));
                product.setStock(set.getInt("stock"));
                productList.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        context.setAttribute("productList",productList);
        context.log("应用程序已启动:"+ LocalTime.now());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         context = sce.getServletContext();
         context.removeAttribute("productList");
         context.log("应用程序已关闭:"+ LocalTime.now());
    }
}
