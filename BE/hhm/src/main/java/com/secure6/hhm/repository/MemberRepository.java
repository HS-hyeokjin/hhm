package com.secure6.hhm.repository;

import com.secure6.hhm.DTO.MemberDTO;
import com.secure6.hhm.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {

    public MemberDTO save(MemberDTO member) throws SQLException {
        String sql = "insert into member(memberId, password, name) values (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstat = null;

        try {
            conn = getConnection();
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, member.getMemberId());
            pstat.setString(2, member.getPassword());
            pstat.setString(3, member.getName());
            pstat.executeUpdate();
            return member;
        } catch (SQLException e) {
            throw e;
        } finally {
            close(pstat, conn, null);
        }
    }

    private void close(PreparedStatement pstat, Connection conn, ResultSet rs) {
        if (pstat != null) {
            try {
                pstat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }

}
