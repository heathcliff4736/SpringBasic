package com.ssg.membertest;

import java.util.List;

public interface MemberDAO {


    void save(MemberDTO memberDTO);

    List<MemberDTO> findAll();
}
