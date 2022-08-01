package com.github.note.o7SQL;

import java.io.File;
import java.sql.*;

public class JDBCQueryDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println(isCorrectPassword("小明", 90));
        System.out.println(isCorrectPassword("小红", 80));
    }

    private static boolean isCorrectPassword(String name, int score) throws SQLException {
        String sql = "SELECT * FROM STUDENTS WHERE NAME = ? AND SCORE = ?";
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        String jdbcUrl = "jdbc:h2:file:" + new File(projectDir,
                                                    "src/main/java/com/github/note/o7SQL/db/test").getAbsolutePath();

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
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
