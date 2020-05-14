package com.Ida.www.dao.Impl;

import com.Ida.www.dao.AdminDao;
import com.Ida.www.po.Admin;
import com.Ida.www.po.Student;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;
import com.Ida.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

     Connection conn = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;

    @Override
    public Admin getLogPassword(String username) throws SQLException {
        Admin admin = null;

        conn = JdbcUtils.getConnection();
        String sql= "select *from admin where username = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            admin = new Admin();
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
        }
        return admin;
    }

    @Override
    public void regTeacher(Teacher teacher) throws SQLException {
            Connection conn = (Connection)JdbcUtils.getConnection();

            String sql = "insert into test.teacher( username, password) values (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getUsername());
            pstmt.setString(2,teacher.getPassword());
            pstmt.execute();
            JdbcUtils.close(null,pstmt,conn);
    }

    @Override
    public int findTeacherId(String username) throws SQLException {
        conn = JdbcUtils.getConnection();
        String sql = "select id from test.teacher where username = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        rs = pstmt.executeQuery();
        int id  = rs.getInt("id");
        return  id;
    }

    @Override
    public void addTeacherMsg(TeacherMsg teacherMsg) throws SQLException {
        conn = JdbcUtils.getConnection();
        String sql = "insert into teacher_msg(name,college,teacher_id)values(?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,teacherMsg.getName());
        pstmt.setString(2,teacherMsg.getCollege());
        pstmt.setInt(3,teacherMsg.getTeacher_id());
        pstmt.execute();
        JdbcUtils.close(null,pstmt,conn);
    }

    /**审核学生注册*/
    @Override
    public List<Student> readReg() throws SQLException {
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
        return students;
    }
}
