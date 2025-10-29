package com.ssg.memberservicetest.service;


import com.ssg.memberservicetest.dto.MemberDTO;

import com.ssg.memberservicetest.mapper.MemberMapper;
import com.ssg.memberservicetest.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;



    @Override
    @Transactional
    public void joinMember(MemberDTO member) {
        memberMapper.insert(member);

    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberDTO> memberList() {
        return memberMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO findById(String userId) {
        return memberMapper.findById(userId);
    }
}
