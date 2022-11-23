package com.secure6.hhm.controller;

import com.secure6.hhm.dto.MemberDto;
import com.secure6.hhm.dto.MemberLoginDto;
import com.secure6.hhm.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/member")
public class MemberController {

    MemberRepository memberRepository = new MemberRepository();

    @GetMapping("/login")
    public String MemberLogin(MemberLoginDto memberLogin){
        return memberLogin.toString();
    }

    @PostMapping("/register")
    public String Member(MemberDto member) throws SQLException {
        memberRepository.save(member);
        return member.toString();
    }

}

