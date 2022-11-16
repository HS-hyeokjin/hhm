package com.secure6.hhm.DTO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {
    private String memberId;
    private String password;
    private String name;
}