package com.secure6.hhm.controller;

import com.secure6.hhm.dto.PostDto;
import com.secure6.hhm.repository.PostRepository;
import com.secure6.hhm.repository.PostRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {

    PostRepository postRepository = new PostRepositoryImpl();

    @GetMapping
    public String test(Model model) throws SQLException {

        List<PostDto> result = postRepository.findAll();

        model.addAttribute("post", result);

        return "main";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "word") String word, Model model) throws SQLException {

        List<PostDto> result = postRepository.search(word);

        model.addAttribute("search", result);

        return "post";
    }

}
