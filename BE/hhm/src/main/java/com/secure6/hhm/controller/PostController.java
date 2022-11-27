package com.secure6.hhm.controller;

import com.secure6.hhm.dto.PostDto;
import com.secure6.hhm.repository.PostRepository;
import com.secure6.hhm.repository.PostRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {

    PostRepository postRepository = new PostRepositoryImpl();

    @GetMapping()
    public ResponseEntity<List<PostDto>> getAll() throws SQLException {

        List<PostDto> result = postRepository.findAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PostDto>> search(@RequestParam(value = "word") String word) throws SQLException {

        List<PostDto> result = postRepository.search(word);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable("id") int id) throws SQLException {

        PostDto result = postRepository.findById(id);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody PostDto postDto) throws SQLException {

        int result = postRepository.update(postDto);

        String message = null;

        System.out.println(postDto.getId());

        if (result == 1) {
            message = "수정 성공했습니다.";
            return ResponseEntity.ok(message);
        } else {
            message = "수정에 실패했습니다.";
            return ResponseEntity.badRequest().body(message);
        }

    }

}
