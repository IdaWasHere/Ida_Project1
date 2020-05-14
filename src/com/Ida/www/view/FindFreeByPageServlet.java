package com.Ida.www.view;

import com.Ida.www.po.PageBean;
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

@WebServlet("/findFreeByPageServlet")
public class FindFreeByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");

        //service
        TeacherService teacherService = new TeacherServiceImpl();
        //泛型实例化
        PageBean<TeacherMsg> pb = null;
        try {
            pb = teacherService.findMsgByPage(currentPage,rows,null);
            System.out.println(pb);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(pb);
        //将pageBean存入request
        request.setAttribute("pb",pb);

        //转发
        request.getRequestDispatcher("FreetimeList.jsp").forward(request,response);
    }
}
