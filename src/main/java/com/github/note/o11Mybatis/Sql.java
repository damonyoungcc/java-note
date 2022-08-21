package com.github.note.o11Mybatis;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sql {
    // 用户信息
    public static class User {
        Integer id;
        String name;
        String tel;
        String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + ", tel='" + tel + '\'' + ", address='" + address + '\'' + '}';
        }
    }

    interface UserMapper {
        @Select("select * from user")
        List<User> getUsers();
    }

    public static void main(String[] args) throws SQLException, IOException {
        User user = new User();
        user.id = 3;
        user.name = "wangwu";

        String resource = "db/mybatis/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.getUsers());

            // 使用xml文件查询User
            System.out.println(session.selectList("com.github.note.UserMapper.selectUser"));
            System.out.println(session.selectList("com.github.note.UserMapper.selectUser", user));

            // 传一个map
            Map<String, Object> param = new HashMap<>();
            param.put("name", "wangwu");
            System.out.println(session.selectList("com.github.note.UserMapper.selectUserByName", param));

            // 动态Sql
            param.put("ids", Arrays.asList(1, 2, 3, 4, 5));
            System.out.println(session.selectList("com.github.note.UserMapper.selectIds", param));
        }
    }
}
