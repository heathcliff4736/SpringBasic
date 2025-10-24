package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.MemberDAO;
import com.ssg.webmvc.todo.domain.MemberVO;
import com.ssg.webmvc.todo.dto.MemberDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        this.memberDAO = new MemberDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO memberVO = memberDAO.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }
}
