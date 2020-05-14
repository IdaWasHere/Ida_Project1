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

@WebServlet("/studentRegServlet")
public class StudentRegServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);


        //调用service层
        StudentService studentService = new StudentServiceImpl();
        try {
            studentService.applyreg(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("success.html");

    }
}