package com.Ida.www.view;

import com.Ida.www.po.Apply;
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

@WebServlet(name = "findApplyServlet",urlPatterns = "/findApplyServlet")
public class FindApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        List<Apply> applys = new ArrayList<>();
        //调用Teacherservice
        TeacherService teacherService = new TeacherServiceImpl();
        try {
             applys =  teacherService.findAllApply();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(applys);
        request.setAttribute("applys",applys);
        request.getRequestDispatcher("/applyList.jsp").forward(request,response);

    }
}
