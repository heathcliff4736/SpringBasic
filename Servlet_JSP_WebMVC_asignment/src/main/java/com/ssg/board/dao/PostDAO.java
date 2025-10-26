package com.ssg.board.dao;

import com.ssg.board.domain.PostVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

    }

    public boolean countAll() throws Exception {
        String sql = "SELECT COUNT(*) FROM board_post";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;

        while (resultSet.next()) {
            count += 1;
        }
        return count == 1;
    }

    public Optional<PostVO> findById(long id) throws Exception {
        String sql = "SELECT * FROM board_post WHERE post_id=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, id);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            return Optional.empty();
        }

        PostVO postVO = PostVO.builder()
                .postId(resultSet.getLong("post_id"))
                .title(resultSet.getString("title"))
                .content(resultSet.getString("content"))
                .writer(resultSet.getString("writer"))
                .passphrase(resultSet.getString("passphrase"))
                .createdAt(resultSet.getTimestamp("created_at").toLocalDateTime())
                .updatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime())
                .build();

        return Optional.of(postVO);
    }

    public long save(PostVO post) throws Exception {
        String sql = "INSERT INTO board_post (title, content, writer, passphrase) "
                + "VALUES (?, ?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement =
                connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, post.getTitle());
        preparedStatement.setString(2, post.getContent());
        preparedStatement.setString(3, post.getWriter());
        preparedStatement.setString(4, post.getPassphrase());

        int count = preparedStatement.executeUpdate();

        if (count == 0) {
            throw new Exception("게시글 저장 실패");
        }

        // DB가 생성한 PK(post_id) 가져오기
        @Cleanup ResultSet rs = preparedStatement.getGeneratedKeys();
        rs.next();
        long generatedId = rs.getLong(1);

        return generatedId;
    }

    public boolean update(PostVO post) throws Exception {

        String sql = "UPDATE board_post set title=?, content=?, writer=?, passphrase=? where post_id=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, post.getTitle());
        preparedStatement.setString(2, post.getContent());
        preparedStatement.setString(3, post.getWriter());
        preparedStatement.setString(4, post.getPassphrase());

        preparedStatement.setLong(5, post.getPostId());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean checkPassphrase(long id, String passphrase) throws Exception {
        String sql = "SELECT COUNT(*) FROM board_post WHERE post_id=? AND passphrase=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, passphrase);

        @Cleanup ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        return rs.getInt(1) > 0;
    };



    /*

    public boolean  delete(long id){};
    */

}
