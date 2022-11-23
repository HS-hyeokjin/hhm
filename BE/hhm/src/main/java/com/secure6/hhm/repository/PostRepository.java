package com.secure6.hhm.repository;

import com.secure6.hhm.dto.PostDto;

import java.sql.SQLException;
import java.util.List;

public interface PostRepository {

    List<PostDto> search(String word) throws SQLException;

}
