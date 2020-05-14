package com.Ida.www.view;

import com.Ida.www.po.Student;
import com.Ida.www.service.ServiceImpl.StudentServiceImpl;
import com.Ida.www.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/studentLogServlet")
public class StudentLogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StudentService studentService = new StudentServiceImpl();
        Student student = null;
        try {
            student = studentService.getLogPassword(username);
            System.out.println(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //4.进行验证
        if(student == null){
            response.setContentType("text/html;charset = utf-8");
            response.getWriter().write("用户名不存在");
        }else if(student.getPassword().equals(password)){
            response.sendRedirect("success.html");
        }else {
            response.setContentType("test/html;charset=utf-8");
            response.getWriter().print("密码错误");
        }
    }
}
