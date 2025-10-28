package com.ssg.membertest;

import com.ssg.membertest.member.MemberDAO;
import com.ssg.membertest.member.MemberDTO;
import com.ssg.membertest.member.MemberSerivce;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.now;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private MemberSerivce memberService;

    @Test
    public void testDataSource() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info("---------------------------------------------------------------------------------------");
        log.info(connection);
        log.info("---------------------------------------------------------------------------------------");
        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testFindAllDAO() throws Exception {
        List<MemberDTO> dtoList = memberDAO.findAll();
        dtoList.forEach(log::info);
    }

    @Test
    public void testFindAllService() throws Exception {
        List<MemberDTO> dtoList = memberService.memberList();
        dtoList.forEach(log::info);
    }


    @Test
    public void testSaveDAO() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .userId("member99")
                .userPwd("1234")
                .userName("구길동")
                .userEmail("member99@gmail.com")
                .joinDate(LocalDate.now())
                .build();
        memberDAO.insert(memberDTO);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSaveService() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .userId("member13")
                .userPwd("1234")
                .userName("김수지")
                .userEmail("suarez09@gmail.com")
                .joinDate(LocalDate.now())
//                .joinDate(LocalDate.of(2023, 5, 10))
                // .joinDate(LocalDate.parse("2023-05-10"))
                .build();
        memberService.joinMember(memberDTO);
    }
}
