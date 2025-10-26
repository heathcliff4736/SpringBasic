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

@Log4j2
@WebServlet(name="postDetailServlet", urlPatterns = "/posts/view")
public class PostDetailServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("/posts/detail doGet............");

        try{
            Long postId = Long.parseLong(req.getParameter("id"));
            PostDTO postDTO = postService.getDetail(postId);
            req.setAttribute("dto", postDTO);
            req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("게시글 상세 조회 오류", e);
            throw new ServletException("게시글 상세 조회 실패", e);
        }
    }
}
