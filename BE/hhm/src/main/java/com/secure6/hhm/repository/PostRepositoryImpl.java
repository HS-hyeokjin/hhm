package com.secure6.hhm.repository;

import com.secure6.hhm.connection.DBConnection;
import com.secure6.hhm.dto.PostDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Override
    public List<PostDto> search(String word) throws SQLException {
        String sql = "SELECT id, title, writer FROM post WHERE title LIKE '%" + word + "%'";

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<PostDto> result = new ArrayList<>();
        try {
            conn = getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
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
            close(stat, null, conn, rs);
        }
    }

    @Override
    public List<PostDto> findAll() throws SQLException {
        String sql = "SELECT id, title, writer FROM post";

        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        List<PostDto> result = new ArrayList<>();
        try {
            conn = getConnection();
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery(sql);
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
            close(null, pstat, conn, rs);
        }
    }

    @Override
    public PostDto findById(int id) throws SQLException{
        String sql = "SELECT * FROM post WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        PostDto result = new PostDto();
        try {
            conn = getConnection();
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setTitle(rs.getString("title"));
                result.setContent(rs.getString("content"));
                result.setWriter(rs.getString("writer"));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(null, pstat, conn, rs);
        }
    }

    @Override
    public int update(PostDto postDto) throws SQLException {
        String sql = "UPDATE post SET title = ?, content = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstat = null;
        int success = 0;
        try {
            conn = getConnection();
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, postDto.getTitle());
            pstat.setString(2, postDto.getContent());
            pstat.setInt(3, postDto.getId());
            success = pstat.executeUpdate();

            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(null, pstat, conn, null);
        }
    }

    private void close(Statement stat, PreparedStatement pstat, Connection conn, ResultSet rs) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
