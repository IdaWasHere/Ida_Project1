package com.Ida.www.service.ServiceImpl;

import com.Ida.www.dao.AdminDao;
import com.Ida.www.dao.Impl.AdminDaoImpl;
import com.Ida.www.po.Admin;
import com.Ida.www.po.Student;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;
import com.Ida.www.service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

   @Override
   public Admin getLogPassword(String username) throws SQLException {
       AdminDao adminDao = new AdminDaoImpl();
       return adminDao.getLogPassword(username);
   }

   @Override
   public void regTeacher(Teacher teacher) throws SQLException {
       AdminDao adminDao = new AdminDaoImpl();
       adminDao.regTeacher(teacher);
   }

   @Override
    public int findTeacherId(String username) throws SQLException {
       AdminDao adminDao = new AdminDaoImpl();
       return adminDao.findTeacherId(username);
   }

    @Override
    public void addTeacherMsg(TeacherMsg teacherMsg) throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.addTeacherMsg(teacherMsg);
    }

    @Override
    public List<Student> readReg() throws SQLException {
       AdminDao adminDao = new AdminDaoImpl();
       return adminDao.readReg();
    }
}
