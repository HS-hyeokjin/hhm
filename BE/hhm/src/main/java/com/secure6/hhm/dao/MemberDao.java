package com.secure6.hhm.dao;

import com.secure6.hhm.connection.DBConnection;
import com.secure6.hhm.dto.MemberLoginDto;

import java.sql.*;

public class MemberDao {

    public MemberDao() {
    }

    public String login(MemberLoginDto memberLoginDto) throws SQLException {
        String SQL = String.format("SELECT password FROM member WHERE memberId = '%s'",memberLoginDto.getMemberId());
        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌
            if (rs.next()) {
                if (rs.getString(1).equals(memberLoginDto.getPassword())) {
                    return "로그인성공";
                }
                else {
                    return "비밀번호 불일치";
                }
            }
            return "아이디 불일치";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DB오류";
    }

    private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }
}