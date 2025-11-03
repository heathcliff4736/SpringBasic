package com.ssg.springboard.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
// Map 타입을 자동으로 json 형태로 반환해줌
@RequestMapping("/replys")
public class ReplyController {

    @GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    /*public java.util.Map<String, String> sample() {
        return Map.of("value1", "AAA", "value2", "BBB");
    }*/
    public String sample() {
        return "Hello RestController";
    }
}
