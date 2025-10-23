package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 새로운 객체의 인코딩셋을 맞춤
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("user_id");
        String password = request.getParameter("user_pw");

        System.out.println(username);
        System.out.println(password);

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "아이디 : " + username + "</h1>");
        out.println("<h1>" + "비밀번호 : " + password + "</h1>");
        out.println("</body></html>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
