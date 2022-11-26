package com.secure6.hhm.repository;

import com.secure6.hhm.dto.PostDto;

import java.sql.SQLException;
import java.util.List;

public interface PostRepository {

    // 저장, 수정, 검색

    List<PostDto> search(String word) throws SQLException;
    List<PostDto> findAll() throws SQLException;
    PostDto findById(int id) throws SQLException;
    int update(PostDto postDto) throws SQLException;

}
