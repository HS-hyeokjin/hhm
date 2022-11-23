package com.secure6.hhm.controller;

import com.secure6.hhm.dao.MemberDao;
import com.secure6.hhm.dto.MemberDto;
import com.secure6.hhm.dto.MemberLoginDto;
import com.secure6.hhm.repository.MemberRepository;
import com.secure6.hhm.repository.MemberRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    MemberRepository memberRepository = new MemberRepositoryImpl();
        MemberDao memberDao = new MemberDao();

        @GetMapping("/login")
        public String MemberLogin(MemberLoginDto memberLogin) throws SQLException {
            String rs = memberDao.login(memberLogin);

            return rs;
        }

        @PostMapping("/register")
        public String Member(MemberDto member) throws SQLException {
            memberRepository.save(member);
            return member.toString();
        }

    }

