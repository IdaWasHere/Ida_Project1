package com.Ida.www.dao.Impl;

import com.Ida.www.dao.TeacherDao;
import com.Ida.www.po.Apply;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;
import com.Ida.www.util.JdbcUtil;
import com.Ida.www.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TeacherDaoImpl implements TeacherDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public Teacher getTeacherPassword(String username) throws SQLException {
        Teacher teacher = null;

        conn = JdbcUtils.getConnection();
        String sql = "select *from test.teacher where username = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            teacher = new Teacher();
            teacher.setUsername(rs.getString("username"));
            teacher.setPassword(rs.getString("password"));
        }
        return teacher;
    }

    private JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
   /** @Override
    public List<TeacherMsg> findAll() {
        // 使用jdbc操作数据库
        String sql = "select *from teacher_msg";
        List<TeacherMsg> teachers = template.query(sql,new BeanPropertyRowMapper<TeacherMsg>(TeacherMsg.class));
        return teachers;
    }
*/

    @Override
    public List<TeacherMsg> findAll() throws SQLException {
        String sql =  "select * from teacher_msg ";
        List<TeacherMsg> list = new ArrayList<>();

        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while(rs.next()){
            TeacherMsg teacherMsg = new TeacherMsg();
            teacherMsg.setId(rs.getInt("id"));
            teacherMsg.setName(rs.getString("name"));
            teacherMsg.setCollege(rs.getString("college"));
            teacherMsg.setStarttime(rs.getString("starttime"));
            teacherMsg.setEndtime(rs.getString("endtime"));
            list.add(teacherMsg);
        }
        JdbcUtils .close(rs,pstmt,conn);
        return list;
    }

    /**导师添加空闲时间*/
    @Override
    public void add(TeacherMsg teacherMsg) throws SQLException {
        String sql = "insert into teacher_msg(name,college,starttime,endtime) values(?,?,?,?)";
        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,teacherMsg.getName());
        pstmt.setString(2,teacherMsg.getCollege());
        pstmt.setString(3,teacherMsg.getStarttime());
        pstmt.setString(4,teacherMsg.getEndtime());
        pstmt.execute();
        JdbcUtils.close(null,pstmt,conn);

    }

    @Override
    public void updateFree(TeacherMsg teacherMsg) throws SQLException {
        String sql = "update teacher_msg set name = ? , college=?, starttime=?, endtime=?";
        conn=JdbcUtils.getConnection();
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,"name");
        pstmt.setString(2,"college");
        pstmt.setString(3,"starttime");
        pstmt.setString(4,"endtime");
        pstmt.execute();
        JdbcUtils.close(null,pstmt,conn);

    }

    /**删除空闲时间*/
    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from teacher_msg where id = ?";
        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.execute();
        JdbcUtils.close(null,pstmt,conn);
    }

    /**修改时，先根据id查询teachermsg信息*/
    @Override
    public TeacherMsg findMsgById(int id) throws SQLException {
        String sql = "select *from teacher_msg where id = ?";
        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        TeacherMsg teacherMsg = new TeacherMsg();

        while (rs.next()) {
            teacherMsg.setId(rs.getInt("id"));
            teacherMsg.setName(rs.getString("name"));
            teacherMsg.setCollege(rs.getString("college"));
            teacherMsg.setStarttime(rs.getString("starttime"));
            teacherMsg.setEndtime(rs.getString("endtime"));
        }
        return teacherMsg;
    }



    @Override
    public int findTotalCount(Map<String, String[]> condition) throws SQLException {
        //1.定义模板初始化sql
        String sql = "select count(*) from teacher_msg where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                //？条件的值
                params.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(params.toArray().toString());

        JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<TeacherMsg> findByPage(int start, int rows, Map<String, String[]> condition) throws SQLException {
        String sql = "select * from teacher_msg where 1=1";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                //？条件的值
                params.add("%"+value+"%");
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询的参数
        params.add(start);
        params.add(rows);
        sql=sb.toString();
        System.out.println(sql);
        System.out.println(params);
        return template.query(sql,new BeanPropertyRowMapper<TeacherMsg>(TeacherMsg.class),params.toArray());
    }

    @Override
    public List<Apply> findAllApply() throws SQLException {
        String sql =  "select * from readapply ";
        List<Apply> list = new ArrayList<>();

        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while(rs.next()){
            Apply apply = new Apply();
            apply.setId(rs.getInt("id"));
            apply.setStuName(rs.getString("stuname"));
            apply.setStuCollege(rs.getString("stucollege"));
            apply.setTeaName(rs.getString("teaname"));
            apply.setTime(rs.getString("time"));
            apply.setState(rs.getString("state"));
            list.add(apply);
        }
        JdbcUtils .close(rs,pstmt,conn);
        return list;
    }

    /**审核学生预约请求*/
    @Override
    public void readState(int id,String state) throws SQLException {
        String sql = "update readapply set state=? where id=?;";
        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(2,id);
        pstmt.setString(1,state);
        pstmt.execute();
        JdbcUtils.close(null,pstmt,conn);
    }


    /**@Override
    public void refuseState(int id,String state) throws SQLException {
        String sql = "update readapply set state='不通过' where id=?";
        conn = JdbcUtils.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.execute();
        JdbcUtils.close(null,pstmt,conn);
    }*/
}















