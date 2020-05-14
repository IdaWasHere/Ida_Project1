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

@WebServlet("/readApplySelectedServlet")
public class ReadApplySelectedServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            request.setCharacterEncoding("utf-8");

            //1.获取所有id
            String [ ] ids = request.getParameterValues("uid");
            String state = request.getParameter("dealstate");

            //2.调用service
            TeacherService teacherService = new TeacherServiceImpl();
            try {
                teacherService.readSelectedState(ids,state);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.setAttribute("ids",ids);
            request.setAttribute("state",state);

            //3.跳转查询所有的servlet
            request.getRequestDispatcher("/findApplyServlet").forward(request,response);
         /**   response.sendRedirect(request.getContextPath()+"/findApplyServlet");*/
        }

    }

