package com.secure6.hhm.domain;

public class Post {

    private int id;
    private String title;
    private Member writer;

    public Post(int id, String title, Member writer) {
        this.id = id;
        this.title = title;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getWriter() {
        return writer;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }

}
