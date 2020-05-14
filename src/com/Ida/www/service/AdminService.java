package com.Ida.www.service;
import com.Ida.www.po.Admin;
import com.Ida.www.po.Student;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {

    public Admin getLogPassword(String username) throws SQLException;

    /**管理员注册导师*/
    public void regTeacher(Teacher teacher) throws SQLException;

    /**根据 username 查找特定导师的特定ID*/
    public  int findTeacherId(String username) throws SQLException;

    /**管理员在注册导师时，将导师信息添加到teacher_msg表*/
    public void addTeacherMsg(TeacherMsg teacherMsg) throws SQLException;

    /**管理员审核学生注册*/
    public List<Student> readReg() throws SQLException;

}
