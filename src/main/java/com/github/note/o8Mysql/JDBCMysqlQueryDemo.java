package com.github.note.o8Mysql;

import java.io.File;
import java.sql.*;

public class JDBCMysqlQueryDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println(isCorrectPassword("小明", 90));
        System.out.println(isCorrectPassword("小红", 80));
    }

    private static boolean isCorrectPassword(String name, int score) throws SQLException {
        String sql = "SELECT * FROM students WHERE NAME = ? AND SCORE = ?";
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123qwe";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 1、 通过Connection 提供的prepareStatement，防止sql注入
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, score);
            // 执行Statement对象提供的executeQuery("SELECT * FROM students")并传入SQL语句
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        }

    }
}
