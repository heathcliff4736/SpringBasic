package com.ssg.webmvc.todo.controller;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name ="todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TodoModifyController, doGet---------------------");

        String tnoStr = req.getParameter("tno");
        if (tnoStr == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "tno parameter is missing");
            return;
        }
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);

        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TodoModifyController, doPost---------------------");
        resp.sendRedirect("/todo/modify");
    }
}
