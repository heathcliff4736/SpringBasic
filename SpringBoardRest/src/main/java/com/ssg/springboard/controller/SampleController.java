package com.ssg.springboard.controller;

import com.ssg.springboard.domain.SampleDTOList;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
// URL 작업부터
@RequestMapping("/sample")
public class SampleController {

    // 1. url: /basic get방식 요청 구현      "basic 요청" 로그 메시지 출력
    @GetMapping("/basic")
    public void basic() {
        log.info("basic");
    }

    // 2. url: /ex1 get방식으로 name과 age를 전달하여 전달받은 name과 age로그 메시지로 출력
    // 조건 : 파라미터 age 기본값 20으로 설정
    @GetMapping("/ex1")
    public void ex1(@RequestParam("name") String name, @RequestParam(value = "age", required = false, defaultValue = "20") int age) {
        log.info("name : " + name + " age : " + age);
    }

    // 3. url: /ex02Bean SampleDTOList 받아서 해당 list 로그 출력
/*    public void ex2Bean(SampleDTOList sampleDTOList) {
        log.info(sampleDTOList);
    }*/
}
