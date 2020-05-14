package com.Ida.www.service.ServiceImpl;

import com.Ida.www.dao.Impl.TeacherDaoImpl;
import com.Ida.www.dao.TeacherDao;
import com.Ida.www.po.Apply;
import com.Ida.www.po.PageBean;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;
import com.Ida.www.service.TeacherService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public Teacher getLogPassword(String username) throws SQLException {
         return teacherDao.getTeacherPassword(username);
    }

    @Override
    public List<TeacherMsg> findAll() throws SQLException {
        /**调用dao*/
    return  teacherDao.findAll();
    }

    //导师添加空闲时间
    @Override
    public void add(TeacherMsg teacherMsg) throws SQLException {
        teacherDao.add(teacherMsg);
    }

    @Override
    public void delete(String id) throws SQLException {
        teacherDao.delete(Integer.parseInt(id));
    }

    /**修改时，先根据id查询teachermsg信息*/
    @Override
    public TeacherMsg findMsgById(String id) throws SQLException {
        return  teacherDao.findMsgById(Integer.parseInt(id));
    }

    /**修改空闲时间*/
    @Override
    public void updateFree(TeacherMsg teacherMsg) throws SQLException {
        teacherDao.updateFree(teacherMsg);
    }

    /**删除选中的空闲时间*/
    @Override
    public void delSelected(String[] ids) throws SQLException {
        //遍历
        for(String id :ids){
            //调用dao完成查询
          teacherDao.delete(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<TeacherMsg> findMsgByPage(String _currentPage, String _rows, Map<String, String[]> condition) throws SQLException {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0){
            currentPage = 1;
        }

        //创建空的pageBean对象
        PageBean<TeacherMsg> pb = new PageBean<>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);


        //调用dao查询总记录数
        int totalCount = teacherDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合  计算开始的记录索引
        int start = (currentPage - 1)* rows;
        List<TeacherMsg> list = new ArrayList<>();
        list = teacherDao.findByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = totalCount % rows  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        if(currentPage >= totalPage){
            pb.setCurrentPage(totalPage);
        }

        return pb;
    }

    /**查找学生预约的所有申请*/
    @Override
    public List<Apply> findAllApply() throws SQLException {
        return teacherDao.findAllApply();
    }

    /**审核学生预约请求*/
    @Override
    public void readState(int id,String state) throws SQLException {
        teacherDao.readState(id,state);
    }

    /**批量审核学生预约请求*/
    @Override
    public void readSelectedState(String[] ids, String state) throws SQLException {
        //1.遍历数组
        for(String id : ids) {
            //2.调用dao审核通过
            teacherDao.readState(Integer.parseInt(id), state);
        }
    }

   /** @Override
    public void readApplySelected(String[] ids) throws SQLException {
        //1.遍历数组
        for(String id : ids){
            //2.调用dao审核通过
             teacherDao.readState(Integer.parseInt(id),state);
        }
    }*/
}



















