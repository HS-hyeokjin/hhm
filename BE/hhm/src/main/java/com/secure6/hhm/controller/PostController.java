package com.secure6.hhm.controller;

import com.secure6.hhm.dto.PostDto;
import com.secure6.hhm.repository.PostRepository;
import com.secure6.hhm.repository.PostRepositoryImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PostController {

    PostRepository postRepository = new PostRepositoryImpl();

    @GetMapping("/post")
    public ResponseEntity<List<PostDto>> search(@RequestParam String word) throws SQLException {

        List<PostDto> result = postRepository.search(word);

        return ResponseEntity.ok(result);
    }

}
