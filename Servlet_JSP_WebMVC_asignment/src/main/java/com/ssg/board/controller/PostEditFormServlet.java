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

@WebServlet(name="postEditFormServlet", urlPatterns = "/posts/edit")
@Log4j2
public class PostEditFormServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/posts/edit doGet............");

        try {
            // id 파라미터 받기
            Long postId = Long.parseLong(req.getParameter("id"));

            // 서비스에서 단건 조회
            PostDTO postDTO = postService.getDetail(postId);

            // JSP에서 참조할 이름
            req.setAttribute("dto", postDTO);

            // 수정 폼 JSP로 forward
            req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("게시글 수정 폼 조회 오류", e);
            throw new ServletException("게시글 수정 폼 조회 실패", e);
        }
    }

}
