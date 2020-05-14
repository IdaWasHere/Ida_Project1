package com.Ida.www.view;

import com.Ida.www.service.ServiceImpl.TeacherServiceImpl;
import com.Ida.www.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/refuseApplyServlet")
public class RefuseApplyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
            //1.设置编码
            request.setCharacterEncoding("utf-8");

            int id = Integer.valueOf(request.getParameter("id"));
            String state = request.getParameter("state");

            //service
            TeacherService teacherService = new TeacherServiceImpl();
            try {
                teacherService.readState(id,state);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("/findApplyServlet");
        }
}
