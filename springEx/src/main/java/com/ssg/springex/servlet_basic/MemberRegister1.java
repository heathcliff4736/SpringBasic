package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet_basic/memberRegisterCheck1")
public class MemberRegister1 extends HttpServlet {

    @Override
    public void init() throws ServletException {
//        System.out.println("LoginServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("doHandle");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        String user_gender = request.getParameter("user_gender");
        String[] user_hobby = request.getParameterValues("user_hobby");

        System.out.println("ID : " + user_id);
        System.out.println("비밀번호 : " + user_pwd);
        System.out.println("성별 : " + user_gender);
        for (int i = 0; i < user_hobby.length; i++) {
            String str = user_hobby[i];
            System.out.println("취미" + (i + 1) + " : " + str);
        }

        String data = "<html>";
        data += "<body>";
        data += "<h1> ID : " + user_id + "</h1>";
        data += "<h1> 비밀번호 : " + user_pwd + "</h1>";
        for (int i = 0; i < user_hobby.length; i++) {
            String str = user_hobby[i];
            data += "<h1> 취미" + (i + 1) + " : " + str + "</h1>";
        }
        data += "<a href= 'http://localhost:8080/servlet_basic/memberRegister.html'> 돌아가기 </a>";
        data += "</body>";
        data += "</html>";
        out.print(data);

    }

}
