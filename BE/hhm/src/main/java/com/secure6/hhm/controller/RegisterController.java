package com.secure6.hhm.controller;

import com.secure6.hhm.dto.MemberDTO;
import com.secure6.hhm.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class RegisterController {

    MemberRepository memberRepository = new MemberRepository();

    @ResponseBody
    @PostMapping("/register")
    public String MemberDTO(MemberDTO memberDTO) throws SQLException {

        memberRepository.save(memberDTO);

        return memberDTO.toString();
    }
}

