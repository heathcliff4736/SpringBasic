package com.ssg.membertest.dao;

import com.ssg.membertest.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {


    int insert(MemberDTO memberDTO);

    List<MemberDTO> findAll();
}
