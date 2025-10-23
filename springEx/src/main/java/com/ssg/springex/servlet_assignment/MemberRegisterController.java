package com.ssg.springex.servlet_assignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet("/servlet_assignment/memberRegisterCheck")
public class MemberRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String userId = request.getParameter("user_id");
        String userPwd = request.getParameter("user_pwd");
        String userGender = request.getParameter("user_gender");
        String[] user_hobby = request.getParameterValues("user_hobby");

        MemberVO memberVO = new MemberVO(userId, userPwd, userGender, user_hobby);
//        MemberVO memberVO = new MemberVO();
//        memberVO.setUserId(userId);
//        memberVO.setUserPwd(userPwd);
//        memberVO.setUserGender(userGender);
//        memberVO.setUserHobby(user_hobby);

        MemberDAO memberDAO = new MemberDAO();

        boolean result = memberDAO.insertMember(memberVO);
//        System.out.println(result);

        String message;
        if(result) {
            message = userId+" 님 회원가입 성공하였습니다.";
        } else {
            message = "다시 시도해주세요.";
        }
//        System.out.println(str);

        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
    }
}
