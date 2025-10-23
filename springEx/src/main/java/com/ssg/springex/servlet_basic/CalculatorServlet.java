package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doPost");
        doHandle(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doGet");
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doHandle");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));
        String op = request.getParameter("op");
        String operator = "";
        int answer = 0;

        switch (op){
            case "add":
                operator = "+";
                answer = x + y;
                break;
            case "sub":
                operator = "-";
                answer = x - y;
                break;
            case "mul":
                operator = "*";
                answer = x * y;
                break;
            case "div":
                operator = "/";
                answer = x / y;
                break;
        }
        String data = "<html>";
        data += "<body>";
        data += "<p>" + x + operator + y + "=" + answer + "</p>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }

}
