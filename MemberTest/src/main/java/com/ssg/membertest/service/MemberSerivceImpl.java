package com.ssg.membertest.service;

import com.ssg.membertest.dao.MemberDAO;
import com.ssg.membertest.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberSerivceImpl implements MemberSerivce {

    // DAO 주입
    private final MemberDAO memberDAO;

    @Override
    @Transactional
    public List<MemberDTO> memberList() {
        return memberDAO.findAll();
    }

    @Override
    @Transactional
    public int joinMember(MemberDTO memberDTO) {
        return memberDAO.insert(memberDTO);
    }


}
