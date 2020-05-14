package com.Ida.www.view;

import com.Ida.www.po.Student;
import com.Ida.www.service.AdminService;
import com.Ida.www.service.ServiceImpl.AdminServiceImpl;
import com.Ida.www.service.ServiceImpl.StudentServiceImpl;
import com.Ida.www.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stuApplyRegServlet")
public class StuApplyRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //编码
        request.setCharacterEncoding("utf-8");

        //调用service
        AdminService adminService = new AdminServiceImpl();
        List<Student> list = new ArrayList<>();
        try {
            list = adminService.readReg();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list",list);
        request.getRequestDispatcher("").forward(request,response);
    }
}
