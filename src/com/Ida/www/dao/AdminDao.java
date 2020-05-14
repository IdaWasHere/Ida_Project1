package com.Ida.www.dao;

import com.Ida.www.po.Admin;
import com.Ida.www.po.Student;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

  public Admin getLogPassword(String username) throws SQLException;

  /**管理员注册导师*/
  public void regTeacher(Teacher teacher) throws SQLException;

  /**管理员查找teacher表特定导师对应的ID*/
  public int findTeacherId(String username) throws SQLException;

  /**管理员将导师信息添加到teacherMsg表*/
  public void addTeacherMsg(TeacherMsg teacherMsg) throws SQLException;

  /**审核学生注册*/
  public List<Student> readReg() throws SQLException;
  }

