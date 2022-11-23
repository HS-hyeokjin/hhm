package com.secure6.hhm.dto;


import lombok.Data;


@Data
public class MemberDto {
    private String memberId;
    private String password;
    private String address;
    private String carNumber;
    private Boolean carRegist;
    private Boolean infra;
    private String phoneNumber;
    private String email;
    private String name;
}