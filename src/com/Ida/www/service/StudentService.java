package com.Ida.www.service;

import com.Ida.www.po.Apply;
import com.Ida.www.po.PageBean;
import com.Ida.www.po.Student;
import com.Ida.www.po.TeacherMsg;

import java.sql.SQLException;

public interface StudentService {
    public void applyreg(Student student) throws SQLException;

    /**提交预约申请*/
    public void addApply(Apply apply) throws SQLException;

    /**学生登录找密码*/
    public Student getLogPassword(String username) throws SQLException;

    /**学生登录时 找冻结状态*/
    public String getFreezeState(String username) throws SQLException;
}
