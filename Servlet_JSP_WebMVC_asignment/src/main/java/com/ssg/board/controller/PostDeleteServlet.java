package com.ssg.board.controller;

import com.ssg.board.service.PostService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "postDeleteServlet", urlPatterns = "/posts/delete")
public class PostDeleteServlet extends HttpServlet {

    private PostService postService = PostService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/posts/delete doPost............");

        req.setCharacterEncoding("UTF-8"); // 한글 처리

        String postIdStr = req.getParameter("postId");
        String passphrase = req.getParameter("passphrase");

        if (postIdStr == null || postIdStr.isEmpty()) {
            log.error("postId가 전달되지 않았습니다.");
            resp.sendRedirect("/posts");
            return;
        }

        try {
            long postId = Long.parseLong(postIdStr);

            // 삭제 수행
            postService.remove(postId, passphrase);

            // 성공 시 목록으로
            resp.sendRedirect("/posts");
        } catch (IllegalArgumentException e) {
            // 비밀번호 불일치 등 사용자 오류
            log.warn("삭제 실패: {}", e.getMessage());
            req.setAttribute("errorMsg", e.getMessage());
            req.setAttribute("id", postIdStr);
            // 상세 페이지로 다시 포워딩
            req.getRequestDispatcher("/posts/view?id=" + postIdStr).forward(req, resp);
        } catch (Exception e) {
            log.error("게시글 삭제 중 오류", e);
            throw new ServletException("게시글 삭제 실패", e);
        }
    }
}
