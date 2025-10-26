package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.domain.PostVO;
import com.ssg.board.dto.PostDTO;
import com.ssg.board.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
public enum PostService {
    INSTANCE;

    private final PostDAO postDAO;
    private ModelMapper modelMapper;

    PostService() {
        this.postDAO = new PostDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public List<PostDTO> getList() throws Exception {
        List<PostVO> voList = postDAO.findAll();
        log.info("voList-----------------------------");
        log.info(voList);

        List<PostDTO> dtoList = voList.stream()
                .map(postVO -> {
                    PostDTO dto = modelMapper.map(postVO, PostDTO.class);
                    dto.formatDates();  // 날짜 포맷 적용
                    return dto;
                })
                .collect(Collectors.toList());

        return dtoList;
    }

    public PostDTO getDetail(long id) throws Exception {
        PostVO postVO = postDAO.findById(id)
                .orElseThrow(() -> new Exception("게시글을 찾을 수 없습니다: id=" + id));
        log.info("PostService-getDetail--------------------------");
        log.info(postVO);

        PostDTO postDTO = modelMapper.map(postVO, PostDTO.class);
        postDTO.formatDates(); // 날짜 포맷 적용
        return postDTO;
    }

    // 검증 + 저장
    public long write(PostDTO post) throws Exception {

        // 빈 값 검증
        if (post.getTitle() == null || post.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }
        if (post.getWriter() == null || post.getWriter().trim().isEmpty()) {
            throw new IllegalArgumentException("작성자는 필수입니다.");
        }
        if (post.getContent() == null || post.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("내용은 필수입니다.");
        }

        // DTO -> VO 변환
        PostVO postVO = modelMapper.map(post, PostVO.class);

        log.info("PostService-write--------------------------");
        log.info(postVO);

        long generatedId = postDAO.save(postVO);
        return generatedId;
    }

    // 비번검증 + 수정
    public void edit(PostDTO post, String passphrase) throws Exception {
        log.info("PostService-edit--------------------------");

        // 비밀번호가 다르다면 오류 메시지 출력
        boolean check = postDAO.checkPassphrase(post.getPostId(), passphrase);
        if (!check) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        PostVO postVO = modelMapper.map(post, PostVO.class);
        boolean updated = postDAO.update(postVO);
        if (!updated) {
            throw new Exception("게시글 수정에 실패했습니다.");
        }
    }

    // 비번검증 + 삭제
    public void remove(long id, String passphrase) throws Exception {
        log.info("PostService-remove--------------------------");
        boolean check = postDAO.checkPassphrase(id, passphrase);
        if (!check) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        boolean deleted = postDAO.delete(id);
        if(!deleted) {
            throw new Exception("게시글 삭제에 실패했습니다.");
        }
    }


}

