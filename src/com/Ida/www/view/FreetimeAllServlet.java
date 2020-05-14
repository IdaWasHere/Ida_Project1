package com.Ida.www.view;

import com.Ida.www.po.TeacherMsg;
import com.Ida.www.service.ServiceImpl.TeacherServiceImpl;
import com.Ida.www.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/freetimeAllServlet")
public class FreetimeAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       //编码
       request.setCharacterEncoding("utf-8");
       //调用service
        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherMsg> teacherMsgs = new ArrayList<TeacherMsg>();
        try {
            teacherMsgs = teacherService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //2.将list存进request域
        request.setAttribute("teacherMsgs",teacherMsgs);
        //3.转发到list.jsp
        request.getRequestDispatcher("/FreetimeList.jsp").forward(request,response);
    }
}
