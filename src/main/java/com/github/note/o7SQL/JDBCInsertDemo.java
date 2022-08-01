package com.github.note.o7SQL;

import java.io.File;
import java.math.BigInteger;
import java.sql.*;

public class JDBCInsertDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println(insert());
    }

    private static long insert() throws SQLException {
        String sql = "INSERT INTO STUDENTS (CLASS_ID, NAME, GENDER, SCORE) VALUES (?,?,?,?)";

        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        String jdbcUrl = "jdbc:h2:file:" + new File(projectDir,
                                                    "src/main/java/com/github/note/o7SQL/db/test").getAbsolutePath();

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, 2);
            ps.setObject(2, "大牛");
            ps.setObject(3, "M");
            ps.setObject(4, 80);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            return 0;
        }

    }
}
