package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssamz.biz.common.JdbcUtil;

public class UserDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String USER_LIST = "SELECT * FROM users";
	private String USER_INSERT = "INSERT INTO users VALUES(?, ?, ?, ?)";
	private String USER_UPDATE = "UPDATE users SET name = ?, role = ? WHERE id = ?";
	private String USER_DELETE = "DELETE FROM users WHERE id = ?";
	
	public List<UserVo> getUserList() {
		List<UserVo> userList = new ArrayList<>();
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			
			System.out.println("[USER ¸ñ·Ï]");
			while (rs.next()) {
				UserVo user = new UserVo();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				userList.add(user);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return userList;
	}
	
	public void insertUser(UserVo vo) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	public void updateUser(UserVo vo) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getRole());
			stmt.setString(3, vo.getId());
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	public void deleteUser(String id) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, id);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(stmt, conn);
		}
	}
}
