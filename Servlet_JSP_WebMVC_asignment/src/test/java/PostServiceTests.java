import com.ssg.board.dto.PostDTO;
import com.ssg.board.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostServiceTests {

    private PostService postService;

    @BeforeEach
    void setUp() throws Exception {
        postService = PostService.INSTANCE;
    }

    @Test
    void testGetList() throws Exception {
        postService.getList();
    }

    @Test
    void testGetDetail() throws Exception {
        postService.getDetail(1L);
    }

    @Test
    void testWrite() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("테스트 제목1");
        postDTO.setWriter("tester1");
        postDTO.setContent("테스트 내용입니다.1");
        postDTO.setPassphrase("1234");

        long generatedId = PostService.INSTANCE.write(postDTO);

        System.out.println("생성된 게시글 ID: " + generatedId);
    }

    @Test
    void testEdit() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(8L);
        postDTO.setTitle("업데이트된 테스트 제목22");
        postDTO.setWriter("updated tester22");
        postDTO.setContent("업데이트된 글 내용22");
        postDTO.setPassphrase("12345");
        String passPhrase = "12345";

        PostService.INSTANCE.edit(postDTO, passPhrase);
    }

    @Test
    void testRemove() throws Exception {
        String passPhrase = "1234";
        PostService.INSTANCE.remove(9L, passPhrase);
    }
}
