package com.ssg.springwebmvc.member;

import java.util.List;

public interface MemberDAO {


    int insert(MemberDTO memberDTO);

    List<MemberDTO> findAll();
}
