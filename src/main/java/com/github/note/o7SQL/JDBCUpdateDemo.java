package com.github.note.o7SQL;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUpdateDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println(update());
    }

    static int update() throws SQLException {
        String sql = "UPDATE STUDENTS SET NAME = ? WHERE ID = ?";

        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        String jdbcUrl = "jdbc:h2:file:" + new File(projectDir,
                                                    "src/main/java/com/github/note/o7SQL/db/test").getAbsolutePath();

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, "小牛");
            ps.setObject(2, 11);
            return ps.executeUpdate();
        }
    }
}
