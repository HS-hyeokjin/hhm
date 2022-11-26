package com.secure6.hhm.controller;

import com.secure6.hhm.dto.MemberDto;
import com.secure6.hhm.repository.MemberRepository;
import com.secure6.hhm.repository.MemberRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class RegisterController {

    MemberRepository memberRepository = new MemberRepositoryImpl();

    @PostMapping("/register")
    public String MemberDTO(MemberDto memberDTO) throws SQLException {

        memberRepository.save(memberDTO);

        return memberDTO.toString();
    }

}

