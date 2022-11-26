package com.secure6.hhm.repository;

import com.secure6.hhm.dto.PostDto;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

    PostRepository postRepository = new PostRepositoryImpl();

    @Test
    void search() {

    }

    @Test
    void findAll() throws SQLException {
        List<PostDto> postDtoList = postRepository.findAll();
        assertThat(postDtoList.size()).isEqualTo(4);
    }

    @Test
    void findById() throws SQLException {
        PostDto postDto = postRepository.findById(2);
        assertThat(postDto.getWriter()).isEqualTo("admin");
    }
}