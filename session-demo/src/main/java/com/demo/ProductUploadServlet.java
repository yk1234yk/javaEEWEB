package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@WebServlet(urlPatterns = {"/product-upload"})
@MultipartConfig
public class ProductUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String price = request.getParameter("price");
//        Part对象用于接收上传文件
        Part part = request.getPart("photo");
//        将文件存储到images目录中
        String path = this.getServletContext().getRealPath("/images");
        File f = new File(path);
        if (!f.exists()){//若目录不存在，则创建目录
            f.mkdirs();
        }
        String headers = part.getHeader("content-disposition");
        //得到文件扩展名
        String fname = headers.substring(headers.lastIndexOf("."), headers.length() - 1);
        part.write(path+"\\"+id+fname);
//        返回客户信息
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("商品号: "+id);
        writer.println("<br/>商品名: "+name);
        writer.println("<br/>价格: "+price);
        writer.println("<br/>图片文件: "+id+fname);
        writer.println("<br/>图片大小: "+part.getSize());
        writer.println("<br/><img src='images\\"+id+fname+"'/>");
    }
}
