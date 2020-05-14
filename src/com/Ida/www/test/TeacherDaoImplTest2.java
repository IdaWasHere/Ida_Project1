package com.Ida.www.test;

import com.Ida.www.po.TeacherMsg;
import com.Ida.www.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImplTest2 {

    @Test
    public void findMsgById() throws SQLException {
        int id = 1;
        String sql = "select *from teacher_msg where id = ?";
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet  rs = pstmt.executeQuery();
        while(rs.next()){
            TeacherMsg teacherMsg = new TeacherMsg();
            teacherMsg.setId(rs.getInt("id"));
            teacherMsg.setName(rs.getString("name"));
            teacherMsg.setCollege(rs.getString("college"));
            teacherMsg.setStarttime(rs.getString("starttime"));
            teacherMsg.setEndtime(rs.getString("endtime"));
            System.out.println(teacherMsg);
        }

    }
}