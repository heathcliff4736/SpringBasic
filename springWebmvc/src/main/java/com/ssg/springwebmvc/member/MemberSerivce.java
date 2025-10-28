package com.ssg.springwebmvc.member;

import java.util.List;

public interface MemberSerivce {
    List<MemberDTO> memberList();

    void joinMember(MemberDTO memberDTO);
}
