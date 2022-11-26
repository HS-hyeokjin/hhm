package com.secure6.hhm.repository;

import com.secure6.hhm.dto.MemberDto;

import java.sql.SQLException;

public interface MemberRepository {

    MemberDto save(MemberDto memberDto) throws SQLException;

}
