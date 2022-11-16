package com.secure6.hhm.controller;

import com.secure6.hhm.dto.MemberDto;
import com.secure6.hhm.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class RegisterController {

    MemberRepository memberRepository = new MemberRepository();

    @PostMapping("/register")
    public String MemberDTO(MemberDto memberDTO) throws SQLException {

        memberRepository.save(memberDTO);

        return memberDTO.toString();
    }
}

