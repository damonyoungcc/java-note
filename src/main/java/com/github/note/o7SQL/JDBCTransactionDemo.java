package com.github.note.o7SQL;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTransactionDemo {
    static File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
    private final static String jdbcUrl = "jdbc:h2:file:" + new File(projectDir,
                                                                     "src/main/java/com/github/note/o7SQL/db/test").getAbsolutePath();
    private final static String insertSql = "INSERT INTO STUDENTS (CLASS_ID, NAME, GENDER, SCORE) VALUES (?, ?, ?, ?)";
    private final static String querySql = "SELECT * FROM STUDENTS WHERE score >= ?";

    public static void main(String[] args) throws SQLException {
        insertStudents(1, "大黄", "M", 100);
        insertStudents(2, "大头", "F", 101);
        List<Student> students = queryStudents();
        students.forEach(System.out::println);
    }

    // 插入学生
    static void insertStudents(int class_id, String name, String gender, int score) throws SQLException {
        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            boolean isAutoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, class_id);
                ps.setString(2, name);
                ps.setString(3, gender);
                ps.setInt(4, score);
                int n = ps.executeUpdate();
                System.out.println(n + " inserted.");
            }
            if (score > 100) {
                connection.rollback();
                System.out.println("rollback.");
            } else {
                connection.commit();
                System.out.println("commit.");
            }
            connection.setAutoCommit(isAutoCommit);
        }
    }

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            try (PreparedStatement ps = connection.prepareStatement(querySql)) {
                ps.setInt(1, 90);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        Student std = new Student();
        std.setId(rs.getLong("id"));
        std.setClass_id(rs.getInt("class_id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getString("gender"));
        std.setScore(rs.getInt("score"));
        return std;
    }


    static class Student {
        private long id;
        private int class_id;
        private String name;
        private String gender;
        private int score;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", class_id=" + class_id + ", name='" + name + '\'' + ", gender='" + gender + '\'' + ", score=" + score + '}';
        }
    }
}
