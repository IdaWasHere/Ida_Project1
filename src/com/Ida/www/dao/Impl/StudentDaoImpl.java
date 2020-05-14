package com.Ida.www.dao.Impl;

import com.Ida.www.dao.StudentDao;
import com.Ida.www.po.Apply;
import com.Ida.www.po.Student;
import com.Ida.www.po.Teacher;
import com.Ida.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void applyreg(Student student) throws SQLException {

        Connection conn = JdbcUtils.getConnection();

        String sql = "" + "insert into student_applyreg " + "(username,password)" + "value (?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,student.getUsername());
        pstmt.setString(2,student.getPassword());
        pstmt.execute();

        JdbcUtils.close(null,pstmt,conn);
    }

    @Override
    public void addApply(Apply apply) throws SQLException {
        Connection conn = JdbcUtils.getConnection();

        String sql = "" + "insert into readapply" + " values (default,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,apply.getStuname());
        pstmt.setString(2,apply.getStuCollege());
        pstmt.setString(3,apply.getTeaName());
        pstmt.setString(4,apply.getTime());
        pstmt.execute();

        JdbcUtils.close(null,pstmt,conn);
    }

    @Override
    public Student getStudentPassword(String username) throws SQLException {

        Student student = null;

        Connection conn = JdbcUtils.getConnection();
        String sql = "select *from test.student where username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            student =new Student();
            student.setUsername(rs.getString("username"));
            student.setPassword(rs.getString("password"));
        }
        return student;
    }

    @Override
    public String getFreezeState(String username) throws SQLException {

        Connection conn = JdbcUtils.getConnection();
        String sql = "select *from test.student where username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet rs = pstmt.executeQuery();
        String freeze = null;

        if (rs.next()) {
            freeze = rs.getString("freeze");
        }
        return freeze;
    }
}
