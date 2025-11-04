package com.ssg.springboard.service;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.mappers.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    @Override
    public void register(ReplyVO replyVO) {
        log.info("ReplySerive---------------register--"+replyVO);
        replyMapper.insert(replyVO);
    }

    @Override
    public ReplyVO getOne(Long rno) {
        log.info("ReplySerive---------------getOne--"+rno);
        return replyMapper.selectOne(rno);
    }

    @Override
    public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") Long bno) {

        return replyMapper.getReplyList(cri, bno);
    }

    @Override
    public int getTotal(Criteria criteria){
        return replyMapper.getTotal(criteria);
    }

    @Override
    public boolean modify(ReplyVO replyVO){
        log.info("ReplySerive---------------modify--"+replyVO);
        return replyMapper.updateOne(replyVO) == 1;
    }

    @Override
    public boolean remove(Long rno) {
        return replyMapper.deleteOne(rno) == 1;
    }
}
