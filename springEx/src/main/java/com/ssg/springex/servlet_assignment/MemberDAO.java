package com.ssg.springex.servlet_assignment;

import com.ssg.springex.servlet_assignment.MemberVO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Statement stmt;
    private Connection conn;
    private PreparedStatement pstmt;
    private static HikariDataSource ds;

    // HikariCP 초기 설정은 static 블록에서 한 번만
    static {
        try {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            config.setJdbcUrl("jdbc:mysql://localhost:3306/springexdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8");
            config.setUsername("root");
            config.setPassword("mysql1234");
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            config.setIdleTimeout(30000);
            config.setConnectionTimeout(30000);
            ds = new HikariDataSource(config);
            System.out.println("HikariCP 초기화 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConnDB() throws SQLException {
        conn = ds.getConnection();
    }

    /*
    private void ConnDB() {
        try {
            // 이 부분 아침에 Hikari 쓰는버전으로 수정해보자
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springexdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8", "root", "mysql1234");
            System.out.println("Connection 생성 성공");
            stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

    public boolean insertMember(MemberVO member) {
        boolean bool1 = false;
        try {
            ConnDB();
            String sql = "INSERT INTO memberInfo (userId, userPwd, userGender, userHobby) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getUserGender());
            pstmt.setString(4, String.join(",", member.getUserHobby())); // 배열 → 문자열
            int result = pstmt.executeUpdate();
            if (result > 0) {
                bool1 = true;
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool1;
    }
}
