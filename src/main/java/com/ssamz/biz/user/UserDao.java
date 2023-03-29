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
	
	private String SELECT_USER = "SELECT * FROM users WHERE id = ?";
	private String SELECT_USERS = "SELECT * FROM users";
	private String INSERT_USER = "INSERT INTO users VALUES(?, ?, ?, ?)";
	private String UPDATE_USER = "UPDATE users SET name = ?, role = ? WHERE id = ?";
	private String DELETE_USER = "DELETE FROM users WHERE id = ?";
	
	public UserVo getUser(UserVo uv) {
		UserVo user = null;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(SELECT_USER);
			stmt.setString(1, uv.getId());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new UserVo();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return user;
	}
	
	public List<UserVo> getUserList() {
		List<UserVo> userList = new ArrayList<>();
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(SELECT_USERS);
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
	
	public void insertUser(UserVo uv) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_USER);
			stmt.setString(1, uv.getId());
			stmt.setString(2, uv.getPassword());
			stmt.setString(3, uv.getName());
			stmt.setString(4, uv.getRole());
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	public void updateUser(UserVo uv) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_USER);
			stmt.setString(1, uv.getName());
			stmt.setString(2, uv.getRole());
			stmt.setString(3, uv.getId());
			
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
			stmt = conn.prepareStatement(DELETE_USER);
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
