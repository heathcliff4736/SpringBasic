package com.ssg.springboard.mappers;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    Long insert(ReplyVO replyVO);

    ReplyVO selectOne(Long rno);

    Long updateOne(ReplyVO replyVO);

    Long deleteOne(Long rno);

    List<ReplyVO> getReplyList(@Param("cri") Criteria cri, @Param("bno") Long bno);

    int getTotal(Criteria criteria);

}
