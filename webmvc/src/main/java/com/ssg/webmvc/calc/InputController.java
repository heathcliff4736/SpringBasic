package com.ssg.webmvc.calc;
// PRG 패턴 (POST-Redirect-GET)
// post 방식과 Redirect를 결합하여 사용하는 패턴
// -사용자는 컨트롤러에 원하는 작업을 POST방식으로 처리하기를 요청
// -Post 방식을 컨트롤러에서 처리하고 브라우저는 다른 경로로 이동(GET)
// 하라는 응답(Redirect)
// - 브라우저는 GET 방식으로 이동 (게시판 구현시 사용됨)
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("InputController 요청된 doGet()");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        dispatcher.forward(req, resp);
        // 서블릿에서 전달된 요청을 다른쪽으로 전달 또는 배포하는 역할 객체

    }
}
