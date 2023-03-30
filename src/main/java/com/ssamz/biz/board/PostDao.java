package com.ssamz.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssamz.biz.common.JdbcUtil;

public class PostDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String SELECT_POST = "SELECT * FROM board WHERE seq = ?";
	private String SELECT_LIST = "SELECT * FROM board ORDER BY seq desc";
	private String INSERT_POST = "INSERT INTO board(seq, title, writer, content) VALUES((SELECT nvl(max(seq), 0) + 1 FROM board), ?, ?, ?)";
	private String UPDATE_POST = "UPDATE board SET title = ?, content = ? WHERE seq = ?";
	private String DELETE_POST = "DELETE FROM board WHERE seq = ?";
	
	public PostVo getPost(PostVo pv) {
		PostVo post = null;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(SELECT_POST);
			stmt.setInt(1, pv.getSeq());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				post = new PostVo();
				post.setSeq(rs.getInt("seq"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setWriter(rs.getString("writer"));
				post.setRegDate(rs.getDate("regDate"));
				post.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return post;
	}
	
	public List<PostVo> getPostList(PostVo pv) {
		List<PostVo> postList = new ArrayList<>();
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(SELECT_LIST);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				PostVo post = new PostVo();
				post.setSeq(rs.getInt("seq"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setWriter(rs.getString("writer"));
				post.setRegDate(rs.getDate("regDate"));
				post.setHit(rs.getInt("hit"));
				postList.add(post);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return postList;
	}
	
	public void insertPost(PostVo pv) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_POST);
			stmt.setString(1, pv.getTitle());
			stmt.setString(2, pv.getWriter());
			stmt.setString(3, pv.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	public void updatePost(PostVo pv) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_POST);
			stmt.setString(1, pv.getTitle());
			stmt.setString(2, pv.getContent());
			stmt.setInt(3, pv.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	public void deletePost(PostVo pv) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(DELETE_POST);
			stmt.setInt(1, pv.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
}
