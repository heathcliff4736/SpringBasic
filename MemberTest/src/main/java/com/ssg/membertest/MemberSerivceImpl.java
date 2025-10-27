package com.ssg.membertest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberSerivceImpl implements MemberSerivce {

    // DAO 주입
    private final MemberDAO memberDAO;

    @Override
    public List<MemberDTO> findAll(){
        return memberDAO.findAll();
    }

    @Override
    public void save(MemberDTO memberDTO) {
        memberDAO.save(memberDTO);
    }
}
