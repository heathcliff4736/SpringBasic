package com.ssg.todoservice.mapper;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
// 이거 두개 있어야댐 (연결)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTests {

    // 인터페이스는 생성자가 필요 없으므로 required는 false로 지정
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void TestTimeMapper() {
        log.info("-------------------------------------");
        log.info(todoMapper.getTime());
        log.info("-------------------------------------");
    }

    @Test
    public void testInsert() {
        TodoVO todoVO = TodoVO.builder()
                .title("1000골 넣기")
                .dueDate(LocalDate.parse("2026-12-31"))
                .writer("호날두")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> voList = todoMapper.selectAll();
        log.info(voList);
    }

}
