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

@WebServlet(name="postSaveServlet", value="/posts/save")
@Log4j2
public class PostSaveServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/posts/save doPost............");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String writer = req.getParameter("writer");
        String passphrase = req.getParameter("passphrase");

        // 입력 검증
        if (title == null || title.length() < 2 || title.length() > 200 ||
                writer == null || writer.length() < 1 || writer.length() > 50 ||
                content == null || content.length() < 5 ||
                passphrase == null || passphrase.length() < 4 || passphrase.length() > 20) {

            req.setAttribute("error", "입력값이 유효하지 않습니다. 다시 확인해주세요.");
            req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
            return;
        }

        try {
            PostDTO postDTO = PostDTO.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .passphrase(passphrase)
                    .build();

            postService.write(postDTO);

            resp.sendRedirect("/posts");

        } catch (Exception e) {
            log.error("게시글 저장 중 오류", e);
            throw new ServletException("게시글 저장 실패", e);
        }
    }
}
