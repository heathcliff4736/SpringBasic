package com.ssg.board.dao;

import com.ssg.board.domain.PostVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDAO {

    public List<PostVO> findAll() throws Exception {
        String sql = "SELECT * FROM board_post";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<PostVO> list = new ArrayList<>();

        while (resultSet.next()) {
            PostVO postVO = PostVO.builder()
                    .postId(resultSet.getLong("post_id"))
                    .title(resultSet.getString("title"))
                    .content(resultSet.getString("content"))
                    .writer(resultSet.getString("writer"))
                    .passphrase(resultSet.getString("passphrase"))
                    .createdAt(resultSet.getTimestamp("created_at").toLocalDateTime())
                    .updatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime())
                    .build();

            list.add(postVO);
        }

        return list;

    };

    /*
    public boolean countAll(){};
    public Optional<PostVO> findById(long id){};
    public long save(PostVO post){};
    public boolean  update(PostVO post){};
    public boolean  delete(long id){};
    public boolean checkPassphrase(long id, String passphrase){};
    */

}
