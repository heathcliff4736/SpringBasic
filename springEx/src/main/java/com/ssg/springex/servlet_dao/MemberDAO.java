package com.ssg.springex.servlet_dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Statement stmt;
    private Connection conn;

    private void ConnDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springexdb?serverTimezone=Asia/Seoul&chatEncoding=UTF-8", "root", "mysql1234");
            System.out.println("Connection 생성 성공");
            stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MemberVO> listMembers() {
        List<MemberVO> memberVOList = new ArrayList<MemberVO>();

        try {
            ConnDB();
            String sql = "select * from member";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("userId");
                String pwd = rs.getString("userPwd");
                String name = rs.getString("userName");
                String email = rs.getString("userEmail");
                Date joinDate = rs.getDate("joinDate");

                MemberVO memberVO = new MemberVO();
                memberVO.setId(id);
                memberVO.setPassword(pwd);
                memberVO.setName(name);
                memberVO.setEmail(email);
                memberVO.setJoinDate(joinDate);
                memberVOList.add(memberVO);

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberVOList;
    }
}
