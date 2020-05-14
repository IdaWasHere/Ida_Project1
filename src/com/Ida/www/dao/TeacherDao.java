package com.Ida.www.dao;

import com.Ida.www.po.Apply;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TeacherDao {
    public Teacher getTeacherPassword(String username) throws SQLException;

    /**导师查询空闲时间列表*/
    public List<TeacherMsg> findAll() throws SQLException;

    /**导师添加空闲时间*/
    public void add(TeacherMsg teacherMsg) throws SQLException;

    /**删除空闲时间*/
    public void delete(int id) throws SQLException;

    /**修改时，先根据id查询teachermsg信息*/
    public TeacherMsg findMsgById(int id) throws SQLException;

    /**修改空闲时间*/
    public void updateFree(TeacherMsg teacherMsg) throws SQLException;

    /**查询总记录数
     * @param condition*/
    int findTotalCount(Map<String, String[]> condition) throws SQLException;

    /**分页条件查询每页的记录*/
    List<TeacherMsg> findByPage(int start, int rows, Map<String, String[]> condition) throws SQLException;

    /**查找学生预约的所有申请*/
    public List<Apply> findAllApply() throws SQLException;

    /**审核学生预约请求*/
    public void readState(int id,String state) throws SQLException;

    /**void refuseState(int id,String state) throws SQLException;*/
}











