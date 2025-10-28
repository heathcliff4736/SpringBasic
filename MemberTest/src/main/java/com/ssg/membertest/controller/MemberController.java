package com.ssg.membertest.controller;

import com.ssg.membertest.dto.MemberDTO;
import com.ssg.membertest.service.MemberSerivce;
import com.ssg.membertest.service.MemberSerivceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
@Log4j2
public class MemberController {

    @Autowired
    private MemberSerivce memberSerivce;

    @GetMapping("/list")
    public void list(MemberDTO memberDTO, Model model) {
        log.info("list");
        List<MemberDTO> memberList = memberSerivce.memberList();
        model.addAttribute("memberList", memberList);
    }
}
