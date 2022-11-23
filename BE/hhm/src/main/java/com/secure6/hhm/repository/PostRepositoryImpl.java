package com.secure6.hhm.repository;

import com.secure6.hhm.connection.DBConnection;
import com.secure6.hhm.dto.PostDto;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Override
    public List<PostDto> search(String word) throws SQLException {
        String sql = "SELECT * FROM post WHERE title LIKE '%" + word + "%'";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<PostDto> result = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PostDto postDto = new PostDto();
                postDto.setId(rs.getInt("id"));
                postDto.setTitle(rs.getString("title"));
                postDto.setWriter(rs.getString("writer"));
                result.add(postDto);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(stmt, conn, rs);
        }
    }

    private void close(Statement stat, Connection conn, ResultSet rs) {
        if (stat != null) {
            try {
                stat.close();
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
