package com.Ida.www.view;

import com.Ida.www.po.TeacherMsg;
import com.Ida.www.service.ServiceImpl.TeacherServiceImpl;
import com.Ida.www.service.TeacherService;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateFreeServlet")
public class UpdateFreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取
        String _id = request.getParameter("id");
        int id = Integer.parseInt(_id);
        String name = request.getParameter("name");
        String college = request.getParameter("college");
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");

        //封装
        TeacherMsg teacherMsg = new TeacherMsg();
        teacherMsg.setId(id);
        teacherMsg.setName("name");
        teacherMsg.setCollege("college");
        teacherMsg.setStarttime("starttime");
        teacherMsg.setEndtime("endtime");

        //调用service
        TeacherService teacherService = new TeacherServiceImpl();
        try {
            teacherService.updateFree(teacherMsg);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //跳转
        response.sendRedirect(request.getContextPath()+"/freetimeAllServlet");
    }
}
