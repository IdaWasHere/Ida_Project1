package com.Ida.www.view;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;

@WebServlet("/chatServlet")
public class ChatServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String args = request.getParameter("action");
        if(args.equals("get")){
            get(request, response);
        }
        else if(args.equals("send")){
            send(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();

        ServletContext application = getServletContext();
        String msg = "";

        if(null != application.getAttribute("massage")){
            Vector<String> vec = (Vector<String>)application.getAttribute("massage");
            for (int i = vec.size() -1; i >= 0; i--) {
                msg += "<br>"+vec.get(i);
            }
        }else{
            msg = "欢迎光临聊天室";
        }

        out.println(msg);
    }


    public void send(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");

        ServletContext application = getServletContext();
        String user = request.getParameter("user");
        String speak = request.getParameter("speak");

        String msg = "["+user+"]说："+speak;
        Vector<String> vec = (Vector<String>)application.getAttribute("massage");

        if(vec == null){
            vec = new Vector<String>();
        }

        vec.add(msg);
        application.setAttribute("massage", vec);

    }
}













