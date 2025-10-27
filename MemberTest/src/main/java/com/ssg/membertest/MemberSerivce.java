package com.ssg.membertest;

import java.util.List;

public interface MemberSerivce {
    List<MemberDTO> findAll();

    void save(MemberDTO memberDTO);
}
