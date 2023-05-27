package com.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public interface Dao {
    public static Connection getConnection(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("c3p0");
        Connection connection = null;
        try {
            connection = c3p0.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
