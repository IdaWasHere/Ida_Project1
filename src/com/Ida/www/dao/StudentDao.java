package com.Ida.www.dao;

import com.Ida.www.po.Apply;
import com.Ida.www.po.Student;

import java.sql.SQLException;

public interface StudentDao {
    public void applyreg(Student student) throws SQLException;

    /**学生提交预约申请*/
    public void addApply(Apply apply) throws SQLException;

    Student getStudentPassword(String username) throws SQLException;

    String getFreezeState(String username) throws SQLException;
}
