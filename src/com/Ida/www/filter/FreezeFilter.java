package com.Ida.www.filter;

import com.Ida.www.po.Student;
import com.Ida.www.service.ServiceImpl.StudentServiceImpl;
import com.Ida.www.service.StudentService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter("/studentLogServlet")
public class FreezeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String username = request.getParameter("username");

        StudentService studentService = new StudentServiceImpl();
        try {
            String freeze = studentService.getFreezeState(username);

            if(freeze ==null || freeze == "冻结"){
                response.sendRedirect("StudentLog.html");
                return;
            }else if(freeze == "恢复"){
                //放行
                chain.doFilter(req, resp);
                response.sendRedirect("studentLogServlet");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {
    }

}
