package com.Ida.www.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stuApplyServlet")
public class StuApplyServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
        }

@Override
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //接收
        String teacherName = request.getParameter("name");
        //存入request域
        request.setAttribute("teacherName",teacherName);
        //转发到try.jsp
        request.getRequestDispatcher("stuApply.jsp").forward(request,response);


    }
}













