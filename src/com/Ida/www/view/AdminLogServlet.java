package com.Ida.www.view;

import com.Ida.www.po.Admin;
import com.Ida.www.service.AdminService;
import com.Ida.www.service.ServiceImpl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adminLogServlet")
public class AdminLogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");

        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminService adminService = new AdminServiceImpl();
        Admin admin = null;
        try {
            admin = adminService.getLogPassword(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

          //4.进行验证
        if(admin == null){
            response.setContentType("text/html;charset = utf-8");
            response.getWriter().write("用户名不存在");
        }else if(admin.getPassword().equals(password)){
            response.sendRedirect("AdminRegTeacher.html");
        }else {
            response.setContentType("test/html;charset=utf-8");
            response.getWriter().print("密码错误");
        }
    }
}
