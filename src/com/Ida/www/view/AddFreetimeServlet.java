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
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@WebServlet("/addFreetimeServlet")
public class AddFreetimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.接收
        String name = request.getParameter("name");
        String college = request.getParameter("college");
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        //3.封装
        TeacherMsg teacherMsg = new TeacherMsg();
        teacherMsg.setName(name);
        teacherMsg.setCollege(college);
        teacherMsg.setStarttime(starttime);
        teacherMsg.setEndtime(endtime);

        //调用service
        TeacherService teacherService = new TeacherServiceImpl();
        try {
            teacherService.add(teacherMsg);
        } catch (SQLException e) {
            e.printStackTrace();
        }

      //跳转到FreetimeListServlet
        response.sendRedirect(request.getContextPath()+"/freetimeAllServlet");
    }
}
