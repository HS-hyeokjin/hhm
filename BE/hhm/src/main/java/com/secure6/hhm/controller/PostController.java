package com.secure6.hhm.controller;

import com.secure6.hhm.dto.PostDto;
import com.secure6.hhm.repository.PostRepository;
import com.secure6.hhm.repository.PostRepositoryImpl;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {

    PostRepository postRepository = new PostRepositoryImpl();

    @GetMapping
    public List<PostDto> getAll(Model model) throws SQLException {

        List<PostDto> result = postRepository.findAll();

        return result;
    }

    @GetMapping("/search")
    public List<PostDto> search(@RequestParam(value = "word") String word) throws SQLException {

        List<PostDto> result = postRepository.search(word);

        return result;
    }

    @GetMapping("/detail/{id}")
    public PostDto getById(@PathVariable("id") int id) throws SQLException {

        PostDto result = postRepository.findById(id);

        return result;
    }

    @PutMapping("/update")
    public int update(PostDto postDto) throws SQLException {

        int result = postRepository.update(postDto);

        return result;
    }

}
