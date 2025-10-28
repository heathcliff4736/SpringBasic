package com.ssg.springwebmvc.member;

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
    public List<MemberDTO> memberList(){
        return memberDAO.findAll();
    }

    @Override
    @Transactional
    public void joinMember(MemberDTO memberDTO) {
        memberDAO.insert(memberDTO);
    }


}
