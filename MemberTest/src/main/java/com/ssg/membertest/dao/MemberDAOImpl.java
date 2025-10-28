package com.ssg.membertest.dao;

import com.ssg.membertest.dto.MemberDTO;
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
            memberDTO.setMid(rs.getString("mid"));
            memberDTO.setMpw(rs.getString("mpw"));
            memberDTO.setMname(rs.getString("mname"));

            return memberDTO;
        }
    };

//    @Autowired
//    private DataSource dataSource;

    @Override
    public int insert(MemberDTO memberDTO) {
        String sql = "INSERT INTO t_member(mid, mpw, mname) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql,
                memberDTO.getMid(),
                memberDTO.getMpw(),
                memberDTO.getMname()
        );
    }

    @Override
    public List<MemberDTO> findAll() {
        String sql = "select * from t_member";
        return jdbcTemplate.query(sql, MEMBER_DTO_ROW_MAPPER);
    }
}
