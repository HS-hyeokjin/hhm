package com.secure6.hhm.dto;

import lombok.Getter;

@Getter
public class PostDto {

    private int id;
    private String title;
    private String content;
    private String writer;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) { this.content = content; }

    public void setWriter(String writer) {
        this.writer = writer;
    }

}
