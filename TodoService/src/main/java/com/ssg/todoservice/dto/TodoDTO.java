package com.ssg.todoservice.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Long tno;

    @NotEmpty
    private String title;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotEmpty
    private String writer;

    private boolean finished;
}
