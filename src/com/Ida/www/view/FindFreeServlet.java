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

@WebServlet("/findFreeServlet")
public class FindFreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.获取id
        String id = request.getParameter("id");
        //2.调用service
        TeacherService teacherService = new TeacherServiceImpl();
        TeacherMsg teacherMsg = new TeacherMsg();
        try {
            teacherMsg = teacherService.findMsgById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //将teacherMsg存入request
        request.setAttribute("teacherMsg",teacherMsg);
        //4.转发到updateFree.jsp
        request.getRequestDispatcher("/UpdateFree.jsp").forward(request,response);
    }
}
