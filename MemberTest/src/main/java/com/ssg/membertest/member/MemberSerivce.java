package com.ssg.membertest.member;

import java.util.List;

public interface MemberSerivce {
    List<MemberDTO> memberList();

    void joinMember(MemberDTO memberDTO);
}
