package com.ssg.membertest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

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
    public void testFindAllDAO() throws Exception {
        List<MemberDTO> dtoList = memberDAO.findAll();
        dtoList.forEach(log::info);
    }

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
    public void testFindAllService() throws Exception {
        List<MemberDTO> dtoList = memberService.findAll();
        dtoList.forEach(log::info);
    }

    @Test
    public void testSaveDAO() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid("member99")
                .mpw("1234")
                .mname("구길동")
                .build();
        memberDAO.save(memberDTO);
    }

    @Test
    public void testSaveService() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid("member98")
                .mpw("1234")
                .mname("날두형")
                .build();
        memberService.save(memberDTO);
    }
}
