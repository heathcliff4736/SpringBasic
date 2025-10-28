package com.ssg.springwebmvc.member;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<MemberDTO> MEMBER_DTO_ROW_MAPPER = new RowMapper<MemberDTO>() {

        @Override
        public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setUserId(rs.getString("userId"));
            memberDTO.setUserName(rs.getString("userPwd"));
            memberDTO.setUserName(rs.getString("userName"));
            memberDTO.setUserEmail(rs.getString("userEmail"));
            java.sql.Date joinDate = rs.getDate("joinDate");
            memberDTO.setJoinDate(joinDate != null ? joinDate.toLocalDate() : null);
            return memberDTO;
        }
    };

//    @Autowired
//    private DataSource dataSource;

    @Override
    public int insert(MemberDTO memberDTO) {
        String sql = "INSERT INTO member(userId, userPwd, userName, userEmail, joinDate) VALUES(?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                memberDTO.getUserId(),
                memberDTO.getUserPwd(),
                memberDTO.getUserName(),
                memberDTO.getUserEmail(),
                java.sql.Date.valueOf(memberDTO.getJoinDate())
        );
    }

    @Override
    public List<MemberDTO> findAll() {
        String sql = "select * from member order by userId desc";
        return jdbcTemplate.query(sql, MEMBER_DTO_ROW_MAPPER);
    }
}
