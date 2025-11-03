package springboard.mappers;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.mappers.ReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class ReplyMapperTests {

    @Autowired(required = false)
    ReplyMapper replyMapper;

    @Test
    public void testInsert() {

        for (int i = 0; i < 20; i++) {
            ReplyVO replyVO = ReplyVO.builder()
                    .bno(1024L)
                    .replyText("test reply ... " + i)
                    .replyer("댓글맨"+i)
                    .build();

            log.info(replyMapper.insert(replyVO));
        }
    }

    @Test
    public void testSelectOne() {
        long rno = 20L;
        ReplyVO replyVO = replyMapper.selectOne(rno);
        log.info(replyVO);
    }

    @Test
    public void testUpdate() {
        ReplyVO replyVO = ReplyVO.builder()
                .rno(22L)
                .replyText("reply updated ...")
                .build();

        log.info(replyMapper.updateOne(replyVO));
    }

    @Test
    public void testDelete() {
        long rno = 23L;
        log.info(replyMapper.deleteOne(rno));
    }

    @Test
    public void testSelectAll() {
        Criteria cri = new Criteria();
        // 1 10

//        replyMapper.getReplyList(cri,1024L).forEach(replyVO -> log.info(replyVO));
        replyMapper.getReplyList(cri,1L).forEach(replyVO -> log.info(replyVO));
    }


}
