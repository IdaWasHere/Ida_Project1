package com.Ida.www.view;

import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;
import com.Ida.www.service.AdminService;
import com.Ida.www.service.ServiceImpl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/teacherRegServlet")
public class TeacherRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String name = request.getParameter("name");
        String college = request.getParameter("college");

        //封装teacher对象
        Teacher teacher = new Teacher();
        teacher.setUsername(username);
        teacher.setPassword(password);


        //调用service层
        AdminService adminService = new AdminServiceImpl();
        try {
            //注册导师账号
            adminService.regTeacher(teacher);

            //找到导师对应的id
            int teacherId  = adminService.findTeacherId(username);

            //封装teacherMsg对象
            TeacherMsg teacherMsg = new TeacherMsg();
            teacherMsg.setTeacher_id(teacherId);
            teacherMsg.setName(name);
            teacherMsg.setCollege(college);

            //添加导师信息
            adminService.addTeacherMsg(teacherMsg);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("success.html");

    }
}

