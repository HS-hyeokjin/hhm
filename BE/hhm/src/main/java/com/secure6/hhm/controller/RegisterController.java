package com.secure6.hhm.controller;

import com.secure6.hhm.DTO.MemberDTO;
import com.secure6.hhm.domain.Member;
import com.secure6.hhm.repository.MemberRepository;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class RegisterController {

    MemberRepository memberRepository = new MemberRepository();

    @ResponseBody
    @RequestMapping("/register")
    public String MemberDTO(MemberDTO memberDTO) throws SQLException {

        memberRepository.save(memberDTO);

        return memberDTO.toString();
    }
}

