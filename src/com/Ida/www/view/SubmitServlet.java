package com.Ida.www.view;

import com.Ida.www.po.Apply;
import com.Ida.www.service.ServiceImpl.StudentServiceImpl;
import com.Ida.www.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/submitServlet")
public class SubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //接收
        String teacherName = request.getParameter("teacherName");
        String studentName = request.getParameter("studentName");
        String studentCollege = request.getParameter("studentCollege");
        String time = request.getParameter("time");

        //封装
        Apply apply = new Apply();
        apply.setTeaName(teacherName);
        apply.setStuname(studentName);
        apply.setStuCollege(studentCollege);
        apply.setTime(time);

        //service
        StudentService studentService = new StudentServiceImpl();
        try {
            studentService.addApply(apply);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("success.html");
    }
}
