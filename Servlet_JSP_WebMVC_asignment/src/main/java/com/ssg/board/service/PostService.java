package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.dto.PostDTO;
import com.ssg.board.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;

@Log4j2
public enum PostService {
    INSTANCE;

    private final PostDAO dao;
    private ModelMapper modelMapper;

    PostService() {
        this.dao = new PostDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    /*
    public List<PostDTO> getList() {}
    public PostDTO getDetail(long id) { ... }                  // 조회수 증가 포함
    public long write(PostDTO post) { ... }                    // 검증 + 저장
    public void edit(PostDTO post, String passphrase) { ... }  // 비번검증 + 수정
    public void remove(long id, String passphrase) { ... }     // 비번검증 + 삭제
*/


}

