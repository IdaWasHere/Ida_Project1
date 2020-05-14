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

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      //获取所有id
      String[] ids = request.getParameterValues("t_id");

      //service
      TeacherService teacherService = new TeacherServiceImpl();
      try {
          teacherService.delSelected(ids);
      } catch (SQLException e) {
          e.printStackTrace();
      }

      //跳转
      response.sendRedirect(request.getContextPath()+"/freetimeAllServlet");
  }
}