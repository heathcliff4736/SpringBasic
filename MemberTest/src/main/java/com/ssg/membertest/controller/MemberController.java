package com.ssg.membertest.controller;

import com.ssg.membertest.dto.MemberDTO;
import com.ssg.membertest.service.MemberSerivce;
import com.ssg.membertest.service.MemberSerivceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public void list(Model model) {
        log.info("list");
        List<MemberDTO> memberList = memberSerivce.memberList();
        model.addAttribute("memberList", memberList);
    }

    @GetMapping("/register")
    public String register(MemberDTO memberDTO) {
        log.info("register");
        log.info(memberDTO);
        return "member/register";
    }

    @PostMapping("/save")
    public String save(MemberDTO memberDTO) {
        log.info("save");
        log.info(memberDTO);

        memberSerivce.joinMember(memberDTO);

        return "redirect:/member/list";
    }



}
