package com.secure6.hhm.domain;

import com.secure6.hhm.DTO.MemberDTO;
import lombok.Data;

@Data
public class Member {

    private String memberId;
    private String password;
    private String name;

    public Member() {

    }

    public Member(String memberId, String password, String name) {
        this.memberId= memberId;
        this.password = password;
        this.name = name;
    }

}
