package com.Ida.www.test;

import com.Ida.www.po.TeacherMsg;
import com.Ida.www.util.JdbcUtil;
import com.Ida.www.util.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeacherDaoImplTest {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Test
    public void findAll() throws SQLException {
        String sql =  "select *from teacher_msg ";
        List<TeacherMsg> list = new ArrayList<>();
        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        int count = 0;
        while(rs.next()){
            TeacherMsg teacherMsg = new TeacherMsg();
            teacherMsg.setId(rs.getInt("id"));
            teacherMsg.setName(rs.getString("name"));
            teacherMsg.setCollege("college");
            teacherMsg.setStarttime("starttime");
            teacherMsg.setEndtime("endtime");
            count+=1;
            list.add(teacherMsg);
            System.out.println(list);
        }
        System.out.println(count);
        JdbcUtils .close(rs,pstmt,conn);
    }

}