package com.ssg.springboard.controller;

import com.ssg.springboard.service.TimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/time")
public class TimeController {
    private final TimeService timeService;

    @GetMapping("/txtest")
    public String get(String str) {
        timeService.insertTwo(str);
        return "index";
    }
}
