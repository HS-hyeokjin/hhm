package com.secure6.hhm.repository;

import com.secure6.hhm.dto.MemberDto;
import com.secure6.hhm.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {

    public MemberDto save(MemberDto memberDto) throws SQLException {
        String sql = "insert into memberDto(memberId, password, address, carNumber, carRegist, infra, phoneNumber, email, name) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstat = null;

        try {
            conn = getConnection();
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, memberDto.getMemberId());
            pstat.setString(2, memberDto.getPassword());
            pstat.setString(3, memberDto.getAddress());
            pstat.setString(4, memberDto.getCarNumber());
            pstat.setBoolean(5, memberDto.getCarRegist());
            pstat.setBoolean(6, memberDto.getInfra());
            pstat.setString(7, memberDto.getPhoneNumber());
            pstat.setString(8, memberDto.getEmail());
            pstat.setString(9, memberDto.getName());
            pstat.executeUpdate();
            return memberDto;
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
