package com.Ida.www.service;

import com.Ida.www.po.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TeacherService {
    public Teacher getLogPassword(String username) throws SQLException;

    /** 导师查询所有空闲时间*/
    public List<TeacherMsg> findAll() throws SQLException;

    /**导师添加空闲时间*/
    public  void add(TeacherMsg teacherMsg) throws SQLException;

    /**根据id,导师删除空闲时间*/
    public void  delete(String id) throws SQLException;

    /**修改时，先根据id查询teachermsg信息*/
    public TeacherMsg findMsgById(String id) throws SQLException;

    /**修改空闲时间*/
    public void updateFree(TeacherMsg teacherMsg) throws SQLException;

    /**删除选中的空闲时间*/
    public void delSelected(String[] ids) throws SQLException;

    /**分页条件查询*/
    public PageBean<TeacherMsg> findMsgByPage(String currentPage, String rows, Map<String, String[]> condition) throws SQLException;

    /**查找学生预约的所有申请*/
    public List<Apply> findAllApply() throws SQLException;

    /**审核学生预约请求*/
    public void readState(int id,String state) throws SQLException;

    /**批量审核学生预约请求*/
    public void readSelectedState(String[] ids, String state) throws SQLException;

    /**通过选中*/
    /**void readApplySelected(String[] ids) throws SQLException;*/
}
