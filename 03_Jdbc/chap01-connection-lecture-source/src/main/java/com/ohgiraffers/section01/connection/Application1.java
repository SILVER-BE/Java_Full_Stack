package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {

        Connection con = null;

        try {
            /* 사용할 Driver 등록 */
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost/employee", "ohgiraffers", "ohgiraffers");

            System.out.println("con = " + con);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();            // 예외처리 해줘야함
        } catch (SQLException e) {
            throw new RuntimeException(e);  // 마찬가지로 예외처리
        } finally {                         // 로직 수행 후 항상 닫아줘야 함.
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
