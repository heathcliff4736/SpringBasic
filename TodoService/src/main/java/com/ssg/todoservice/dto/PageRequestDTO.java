package com.ssg.todoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;       // 하나의 페이지의 시작번호는 1페이지부터 시작

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;      //  하나의 페이지에 담길 글의 수

    private String link;

    private String[] types;

    private String keyword;

    private boolean finished;

    private LocalDate from;

    private LocalDate to;

    public int getSkip(){
        return (page - 1) * 10;
    }



}
