package com.secure6.hhm.controller;

import com.secure6.hhm.dao.MemberDao;
import com.secure6.hhm.dto.LoginResponseDto;
import com.secure6.hhm.dto.MemberDto;
import com.secure6.hhm.dto.MemberLoginDto;
import com.secure6.hhm.repository.MemberRepository;
import com.secure6.hhm.repository.MemberRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/member")
public class MemberController {

    MemberRepository memberRepository = new MemberRepositoryImpl();
<<<<<<< Updated upstream

    MemberDao memberDao = new MemberDao();

    @GetMapping("/login")
    public String MemberLogin(MemberLoginDto memberLogin) throws SQLException {
        String rs = memberDao.login(memberLogin);

        return rs;
=======
    MemberDao memberDao = new MemberDao();

    @GetMapping("/login")
    public LoginResponseDto MemberLogin(MemberLoginDto memberLogin) throws SQLException {

        String rs = memberDao.login(memberLogin);

        LoginResponseDto loginResponseDto = new LoginResponseDto();

        if(rs == "로그인성공") {
            loginResponseDto.setState(200);
            loginResponseDto.setRs(memberLogin.getMemberId());
        }
        else {
            loginResponseDto.setState(500);
            loginResponseDto.setRs("로그인실패");
        }
        return loginResponseDto;
>>>>>>> Stashed changes
    }

    @PostMapping("/register")
    public String Member(MemberDto member) throws SQLException {
        memberRepository.save(member);
<<<<<<< Updated upstream
        
=======
>>>>>>> Stashed changes
        return member.toString();
    }

}

