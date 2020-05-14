package com.Ida.www.util;

import java.sql.*;

public class JdbcUtils {
    //1.导包
    //2.注册驱动
    static {
       //加载数据库驱动，注册到驱动管理器
       try {
          Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException e) {
          e.printStackTrace();
       }
    }

    public static Connection getConnection() throws SQLException {
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","root");
       return  conn;
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){

       try {
          if(rs!=null){
             rs.close();
          }
          if (pstmt != null) {
             pstmt.close();
          }
          if(conn !=null) {
             conn.close();
          }
       }catch (SQLException e){
          e.printStackTrace();
       }
    }
}
