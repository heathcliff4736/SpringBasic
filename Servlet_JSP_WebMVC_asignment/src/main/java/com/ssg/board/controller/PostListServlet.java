package com.ssg.board.controller;

import com.ssg.board.dto.PostDTO;
import com.ssg.board.service.PostService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="postListServlet", urlPatterns = "/posts")
@Log4j2
public class PostListServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

//    목록 조회는 서버 상태를 바꾸지 않기 때문에 GET이 맞음
//    POST를 사용해도 동작은 하지만, 웹 표준과 브라우저 캐싱, PRG 패턴에서 문제가 생길 수 있음

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/posts doGet() 호출");
        req.setCharacterEncoding("UTF-8");
        try{
            List<PostDTO> dtoList = postService.getList();
            req.setAttribute("dtoList", dtoList);

            req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new ServletException("post list error", e);
        }
    }
}
