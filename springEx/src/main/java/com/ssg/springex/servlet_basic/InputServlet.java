package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] subject = req.getParameterValues("subject");
        for (String str : subject) {
            System.out.println("선택한 언어 :" + str);
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        for (String str : subject) {
            out.println("<h1>선택한 언어 :" + str+ "</h1>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
