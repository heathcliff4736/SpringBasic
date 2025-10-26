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
            // 비밀번호 불일치 처리
            handleDeleteFailure(req, resp, postIdStr, e.getMessage());
        } catch (Exception e) {
            // 삭제 중 다른 오류 처리
            log.error("게시글 삭제 중 오류", e);
            throw new ServletException("게시글 삭제 실패", e);
        }
    }

    private void handleDeleteFailure(HttpServletRequest req, HttpServletResponse resp,
                                     String postIdStr, String errorMsg) throws ServletException, IOException {
        try {
            PostDTO dto = postService.getDetail(Long.parseLong(postIdStr));
            req.setAttribute("dto", dto);
            req.setAttribute("errorMsg", errorMsg);
            req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
        } catch (Exception ex) {
            log.error("상세 페이지 조회 실패", ex);
            throw new ServletException("상세 페이지 조회 실패", ex);
        }
    }
}
