import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title todo..")
                .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() throws Exception {
        TodoVO todoVO = todoDAO.selectOne(3L);
        System.out.println(todoVO);
    }

    @Test
    public void testDeleteOne() throws Exception {
        todoDAO.deleteOne(3L);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Updated title")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }


}



