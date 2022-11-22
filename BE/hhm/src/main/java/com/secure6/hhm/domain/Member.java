package com.secure6.hhm.domain;

import lombok.Data;

@Data
public class Member {

    private String memberId;
    private String password;
    private String name;

    public Member(String memberId, String password, String name) {
        this.memberId= memberId;
        this.password = password;
        this.name = name;
    }

}
