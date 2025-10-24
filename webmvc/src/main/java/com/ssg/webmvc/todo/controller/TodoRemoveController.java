package com.ssg.webmvc.todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="todoRemoveController")
public class TodoRemoveController extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.info("TodoRemoveController, doGet---------------------");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/remove.jsp");
//        dispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.info("TodoRemoveController, doPost---------------------");
//
//        resp.sendRedirect("/todo/remove");
//    }
}
