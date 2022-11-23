package com.secure6.hhm.repository;

import com.secure6.hhm.connection.DBConnection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class MemberRepositoryTest {

    DBConnection dbConnection = new DBConnection();
    MemberRepositoryImpl memberRepository = new MemberRepositoryImpl();

/*    @Test
    void save() throws SQLException {
        Member member = new Member("admin", "1234", "관리자");
        Member savedMember = memberRepository.save();
        Assertions.assertThat(savedMember).isEqualTo(member);
    }*/

    @Test
    void connection() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Assertions.assertThat(conn).isNotNull();
    }

}