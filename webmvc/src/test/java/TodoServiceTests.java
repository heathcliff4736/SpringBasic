import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("Todo DTO title 1")
                .dueDate(LocalDate.now())
                .build();
        todoService.register(todoDTO);
    }

    @Test
    public void testSelectOne() throws Exception {
        todoService.selectOne(1L);
    }

    @Test
    public void testDeleteOne() throws Exception {
        todoService.deleteOne(4L);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(5L)
                .title("updated DTO title 2 on Service")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        todoService.updateOne(todoDTO);
    }

}
