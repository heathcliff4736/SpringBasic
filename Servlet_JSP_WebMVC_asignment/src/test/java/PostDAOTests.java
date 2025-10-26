import com.ssg.board.dao.PostDAO;
import com.ssg.board.domain.PostVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class PostDAOTests {

    private PostDAO postDAO;

    @BeforeEach
    public void setUp() {
        postDAO = new PostDAO();
    }

    @Test
    public void testFindAll() throws Exception {
        List<PostVO> voList = postDAO.findAll();
        voList.forEach(System.out::println);
    }

    @Test
    public void testFindById() throws Exception {
        Optional<PostVO> postVO = postDAO.findById(2L);
        System.out.println(postVO.get());
    }

    @Test
    public void testSave() throws Exception {
        PostVO postVO = PostVO.builder()
                .title("테스트 title")
                .content("테스트 content")
                .writer("테스트 writer")
                .passphrase("테스트 passphrase")
                .build();

        postDAO.save(postVO);
    }

    @Test
    public void testUpdate() throws Exception {
        PostVO postVO = PostVO.builder()
                .postId(9L)
                .title("업데이트된 테스트 제목")
                .content("업데이트된 글내용")
                .writer("업데이트된 글의 수정자")
                .passphrase("업데이트된 passphrase")
                .build();

        postDAO.update(postVO);
    }

    @Test
    void testDelete() throws Exception {
        postDAO.delete(11L);
    }

    @Test
    void testCheckPhrase() throws Exception {
        System.out.println(postDAO.checkPassphrase(6L, "1234"));
    }
}
