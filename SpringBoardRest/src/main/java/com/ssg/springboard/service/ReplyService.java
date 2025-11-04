package com.ssg.springboard.service;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyService {
    void register(ReplyVO replyVO);

    ReplyVO getOne(Long rno);

    List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") Long bno);

    int getTotal(Criteria criteria);

    boolean modify(ReplyVO replyVO);

    boolean remove(Long rno);
}
