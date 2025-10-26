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

@WebServlet(name = "postUpdateServlet", urlPatterns = "/posts/update")
@Log4j2
public class PostUpdateFormServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/posts/update doPost.........................");

        req.setCharacterEncoding("UTF-8");

        try {
            Long postId = Long.parseLong(req.getParameter("postId"));
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String writer = req.getParameter("writer");
            String passPhrase = req.getParameter("passPhrase");

            PostDTO postDTO = PostDTO.builder()
                    .postId(postId)
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .passphrase(passPhrase) // 혹시나 필요한 경우 ?
                    .build();

            postService.edit(postDTO, passPhrase);

            resp.sendRedirect(req.getContextPath() + "/posts/view?id=" + postId);

        } catch (IllegalArgumentException e) {
            // 비밀번호 불일치 등 검증 실패
            log.warn("게시글 수정 실패: {}", e.getMessage());
            req.setAttribute("errorMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("게시글 수정 오류", e);
            throw new ServletException("게시글 수정 실패", e);
        }

    }
}
