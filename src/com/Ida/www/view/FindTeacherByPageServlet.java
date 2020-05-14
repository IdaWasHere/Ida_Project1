package com.Ida.www.view;

import com.Ida.www.po.PageBean;
import com.Ida.www.po.Teacher;
import com.Ida.www.po.TeacherMsg;
import com.Ida.www.service.ServiceImpl.StudentServiceImpl;
import com.Ida.www.service.ServiceImpl.TeacherServiceImpl;
import com.Ida.www.service.StudentService;
import com.Ida.www.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "findTeacherByPageServlet",urlPatterns = "/findTeacherByPageServlet")
public class FindTeacherByPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");

        //获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");

        //特殊情况：没有传currentPage rows到此servlet
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "2";
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //调用service查询
       TeacherService teacherService = new TeacherServiceImpl();
        //泛型实例化
        PageBean<TeacherMsg> pb = null;
        try {
            pb = teacherService.findMsgByPage(currentPage,rows,condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(pb);

        //将pageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);

        //转发到teacherList.jsp
        request.getRequestDispatcher("/TeacherList.jsp").forward(request,response);
    }
}
