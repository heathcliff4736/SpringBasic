package com.ssg.membertest.member;

import java.util.List;

public interface MemberDAO {


    int insert(MemberDTO memberDTO);

    List<MemberDTO> findAll();
}
