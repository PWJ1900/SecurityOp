package com.injectionuse.dao;

import com.injectionuse.entity.Student;

import java.sql.*;

public class LinkedDao {
    Connection conn  = null;
//    Statement statement = null;
    PreparedStatement pstmt = null;
    public int exeUp(String sql, int id){
        int nums = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 1、创建链接对象
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/secop","root","940731286");
            // 2、通过链接对象创建执行sql命令对象
//            statement = conn.createStatement();
//            statement.execute(sql);

//            ResultSet resUse = statement.getResultSet();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet resUse = pstmt.getResultSet();
            while(resUse.next()) {
                System.out.println(resUse.getString("name"));
                
            }
            // 3、执行sql返回结果

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return nums;

    }
}
