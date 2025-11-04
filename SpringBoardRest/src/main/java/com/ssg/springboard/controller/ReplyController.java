package com.ssg.springboard.controller;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@RestController
// Map 타입을 자동으로 json 형태로 반환해줌
@RequiredArgsConstructor
@RequestMapping("/reply")
@Log4j2
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String registerPost(ReplyVO replyVO, RedirectAttributes redirectAttributes) {
        log.info("replyVO : " + replyVO);
        replyService.register(replyVO);
        Long rno = replyVO.getRno();
        log.info("rno : " + rno);
        redirectAttributes.addFlashAttribute("result", rno);

        return "redirect:/reply/list";
    }

    @GetMapping("/{rno}")
    public String read(
            @PathVariable(name = "rno") Long rno,
            @ModelAttribute("cri") Criteria criteria,
            Model model) {

        log.info("rno : " + rno);

        ReplyVO replyVO = replyService.getOne(rno);

        log.info("replyVO : " + replyVO);

        model.addAttribute("replyVO", replyVO);

        return "/reply/"+rno;
    }

    @DeleteMapping("/{rno}")
    public String remove(@PathVariable(name="rno") Long rno,
                              RedirectAttributes redirectAttributes) {
        replyService.remove(rno);
        return "redirect:/reply/list";
    }

    @PutMapping("/{rno}")
    public String modify(@PathVariable(name = "rno") Long rno,
                              ReplyVO replyVO,
                              RedirectAttributes redirectAttributes) {
        replyVO.setRno(rno);

        log.info("rno : " + rno);
        log.info("replyVO : " + replyVO);

        replyService.modify(replyVO);

        redirectAttributes.addFlashAttribute("result", replyVO.getRno());

        return "redirect:/reply/read";
    }

    @GetMapping("/list/{bno}")
    public void list(@ModelAttribute("cri") Criteria criteria,
                     @PathVariable(name = "rno") Long rno,
                     Model model) {
        List<ReplyVO> replyList = replyService.getList(criteria, rno);

        log.info(replyList);
        model.addAttribute("replyList", replyList);

    }













    @GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    /*public java.util.Map<String, String> sample() {
        return Map.of("value1", "AAA", "value2", "BBB");
    }*/
    public String sample() {
        return "Hello RestController";
    }
}
