package com.Ida.www.test;

import com.Ida.www.po.Student;
import com.Ida.www.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AdminDaoImplTest {

    @Test
    public void readReg() throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = JdbcUtils.getConnection();
        String sql = "select * from student_applyreg";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        Student student = new Student();
        List<Student> students = new ArrayList<>();
        while(rs.next()){
            student.setId(rs.getInt("id"));
            student.setUsername(rs.getString("username"));
            student.setPassword(rs.getString("password"));
            students.add(student);
        }
    }
}