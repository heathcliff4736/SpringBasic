package com.ssg.webmvc.todo.dao;


import com.ssg.webmvc.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String sql = "select * from t_member where mid=? AND mpw=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);

        @Cleanup ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        MemberVO member = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .build();

        return member;
    }
}
