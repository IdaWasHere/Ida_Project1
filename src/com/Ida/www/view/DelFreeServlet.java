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

@WebServlet("/delFreeServlet")
public class DelFreeServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1.获取id
            String id = request.getParameter("id");
            //2.调用service删除
            TeacherService teacherService = new TeacherServiceImpl();
            try {
                teacherService.delete(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //3.跳转到查询所有freetime的servlet
            response.sendRedirect(request.getContextPath() + "/freetimeAllServlet");
        }

}
