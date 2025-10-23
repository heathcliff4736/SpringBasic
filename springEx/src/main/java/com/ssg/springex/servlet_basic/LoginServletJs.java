package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login3")
public class LoginServletJs extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doPost() 메소드 호출");
        doHandle(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doGet() 메소드 호출");
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doHandle 메소드 호출");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        String user_address = request.getParameter("user_address");

        String data = "<html>";
        data += "<body>";
        data += "<h1>" + user_id + "</h1>";
        data += "<h1>" + user_pwd + "</h1>";
        data += "<h1>" + user_address + "</h1>";
        data += "<a href= 'http://localhost:8080/login2.html'> 로그인화면 </a>";
        data += "</body>";
        data += "</html>";
        out.print(data);


    }

}
