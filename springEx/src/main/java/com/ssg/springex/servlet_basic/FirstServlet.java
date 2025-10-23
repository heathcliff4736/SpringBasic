package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "firstServlet", value = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("FirstServlet init() 메소드 호출");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 메소드 호출");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do Get 메소드 호출");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> First Servlet - EHS</h1>");
        out.println("</body></html>");
    }
}
