package com.dao;

import com.domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAoImpl implements BookDao{
//    插入一条图书记录
    @Override
    public int addBook(Book book)  {
        String sql = "insert into books values(?,?,?)";
        try {
            Connection connection = Dao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setFloat(3,book.getPrice());
            int i = statement.executeUpdate();
            return i;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }

    }

//    按isbn删除图书
    @Override
    public int deleteBook(String isbn) {
       String sql = "delete from books where isbn = ?";
       try {
           Connection connection = Dao.getConnection();
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1,isbn);
           int i = statement.executeUpdate();
           return i;
       }catch (SQLException e){
           e.printStackTrace();
           return 0;
       }
    }
}
