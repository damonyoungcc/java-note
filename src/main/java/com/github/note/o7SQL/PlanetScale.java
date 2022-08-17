package com.github.note.o7SQL;

import java.io.File;
import java.sql.*;

public class PlanetScale {
    public static void main(String[] args) throws SQLException {
        System.out.println(query("小明", 90));
    }

    private static boolean query(String name, int score) throws SQLException {
        String sql = "SELECT * FROM students WHERE NAME = ? AND SCORE = ?";
        String jdbcUrl = "jdbc:mysql://ou74o0gjy09s.ap-southeast-2.psdb.cloud/javadb?sslMode=VERIFY_IDENTITY";

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, score);
            // 执行Statement对象提供的executeQuery("SELECT * FROM students")并传入SQL语句
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        }

    }
}
