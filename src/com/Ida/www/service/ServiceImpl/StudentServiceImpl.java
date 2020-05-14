package com.Ida.www.service.ServiceImpl;

import com.Ida.www.dao.Impl.StudentDaoImpl;
import com.Ida.www.dao.StudentDao;
import com.Ida.www.po.Apply;
import com.Ida.www.po.PageBean;
import com.Ida.www.po.Student;
import com.Ida.www.po.TeacherMsg;
import com.Ida.www.service.StudentService;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public void applyreg(Student student) throws SQLException {
        studentDao.applyreg(student);
    }

    @Override
    public void addApply(Apply apply) throws SQLException {
        studentDao.addApply(apply);
    }

    @Override
    public Student getLogPassword(String username) throws SQLException {
        return studentDao.getStudentPassword(username);
    }

    @Override
    public String getFreezeState(String username) throws SQLException {
        return studentDao.getFreezeState(username);
    }
}
