package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "customerList", urlPatterns = {"/customer-list"})
public class CustomerListServlet extends HttpServlet {
    public void addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //可将对象存储到数据库中
        String uniqueID = storeCustomer();
        //创建响应XML
        StringBuffer xml = new StringBuffer("<result><uniqueID>");
        xml.append(uniqueID);
        xml.append("</uniqueID>");
        xml.append("<status>1</status>");
        xml.append("</result>");
        //向浏览器发送响应
        sendResponse(response, xml.toString());
    }

    protected void deleteCustomer(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
//        可将客户从数据库中删除
        //创建响应XML
        StringBuffer xml = new StringBuffer("<result>");
        xml.append("<status>1</status>");
        xml.append("</result>");
        //向浏览器发送响应
        sendResponse(response, xml.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action.equals("add")) {
                addCustomer(req, resp);

            } else if (action.equals("delete")) {
                deleteCustomer(resp, req);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String storeCustomer() {
        //这里可将客户对象保存到数据库中
        String uniqueID = "";
        Random randomizer = new Random(System.currentTimeMillis());
        for (int i = 0; i < 8; i++) {
            uniqueID += randomizer.nextInt(9);
        }
        return uniqueID;
    }

    private void sendResponse(HttpServletResponse response, String responseText) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println(responseText);
    }
}
