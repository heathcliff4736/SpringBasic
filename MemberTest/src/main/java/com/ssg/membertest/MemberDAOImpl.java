package com.ssg.membertest;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@ToString
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void save(MemberDTO memberDTO) {
        String sql = "insert into t_member values(?,?,?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setString(1, memberDTO.getMid());
            preparedStatement.setString(2, memberDTO.getMpw());
            preparedStatement.setString(3, memberDTO.getMname());

            int count = preparedStatement.executeUpdate();

            if (count == 0) {
                throw new Exception("게시글 저장 실패");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MemberDTO> findAll() {
        String sql = "select * from t_member";
        List<MemberDTO> memberDTOList = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()

        ) {
            while (resultSet.next()) {
                MemberDTO memberDTO = MemberDTO.builder()
                        .mid(resultSet.getString(1))
                        .mpw(resultSet.getString(2))
                        .mname(resultSet.getString(3))
                        .build();

                memberDTOList.add(memberDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return memberDTOList;
    }
}
