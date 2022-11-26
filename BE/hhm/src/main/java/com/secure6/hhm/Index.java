package com.secure6.hhm;

import com.secure6.hhm.connection.DBConnection;

import java.sql.*;

public class Index {

    public Index() {}

    public Integer getIndex() throws SQLException {
        String select = "select id from idx";
        String update = "update idx set id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer v = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(select);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                v = rs.getInt("id");
            }
            pstmt = conn.prepareStatement(update);
            pstmt.setInt(1, v + 1);
            pstmt.executeUpdate();
            return v;
        } catch (SQLException e) {
            throw e;
        } finally {
            close(pstmt, conn, rs);
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
