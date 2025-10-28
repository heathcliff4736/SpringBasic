package com.ssg.membertest.service;

import com.ssg.membertest.dto.MemberDTO;

import java.util.List;

public interface MemberSerivce {
    List<MemberDTO> memberList();

    void joinMember(MemberDTO memberDTO);
}
