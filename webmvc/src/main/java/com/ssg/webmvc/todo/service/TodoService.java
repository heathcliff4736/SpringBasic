package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 객체의 개수를 결정할 때 사용한다.
// 현재 INSTANCE가 한 개 이므로
// 컨트롤러가 접근할 수 있는 서비스객체는 1개만 사용하겠다. 라는 의미
// 접근시 : TodoService.INSTANCE
// 객체를 하나만 생성해서 사용 (singletone pattern)
// 여러 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조로 구성
public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG......" + todoDTO);
    }

    // 10개의 TodoDTO 객체를 만들어 반환
    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(
            i -> {
                TodoDTO dto = new TodoDTO();
                dto.setTno((long) i);
                dto.setTitle("Todo..title" + i);
                dto.setDueDate(LocalDate.now());
                return dto;
            }
            ).collect(Collectors.toList());
        return todoDTOS;
    }

    public TodoDTO get(Long tno){
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }

}


// 장점 : 정해진 수만큼 객체를 생성할 수 있다.
