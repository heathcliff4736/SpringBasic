package com.ssg.springboard.mappers;

import com.ssg.springboard.domain.ReplyVO;

import java.util.List;

public interface ReplyMapper {

    Long insert(ReplyVO replyVO);
    ReplyVO selectOne(Long rno);

    Long updateOne(ReplyVO replyVO);
    Long deleteOne(Long rno);
    List<ReplyVO> selectAllReply();

}
