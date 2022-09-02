package com.servlet.study.web.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.servlet.study.web.domain.db.DBConnectionMgr;

public class UserRepository {

	private DBConnectionMgr pool;
	
	public UserRepository() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public List<Map<String, Object>> getUserList() {
		String sql = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			con = pool.getConnection();
			sql = "SELECT\r\n"
					+ "	um.user_code,\r\n"
					+ "	um.user_id,\r\n"
					+ "	um.user_password,\r\n"
					+ "	um.user_name,\r\n"
					+ "	um.user_email,\r\n"
					+ "	ud.user_phone,\r\n"
					+ "	ud.user_address\r\n"
					+ "FROM\r\n"
					+ "	user_mst um\r\n"
					+ "	LEFT OUTER JOIN user_dtl ud ON(ud.user_code = um.user_code)";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				for(int i = 0; i < rsmd.getColumnCount(); i++) {
					int index = i + 1;
					Object value = null;
					
					if(rsmd.getColumnType(index) == Types.INTEGER) {
						value = rs.getInt(index);
						
					}else if(rsmd.getColumnType(index) == Types.VARCHAR) {
						value = rs.getString(index);
						
					}else if(rsmd.getColumnType(index) == Types.TIMESTAMP) {
						value = rs.getTimestamp(index).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
						
					}
					
					map.put(rsmd.getColumnName(index), value);
				}
				
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return list;
	}
	
	public int checkUserId(String userId) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "select count(*) from user_mst where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return result;
	}
	
	public int save(User user) {
		int result = 0;
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = pool.getConnection();
			sql = "insert into user_mst values(0, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_name());
			pstmt.setString(4, user.getUser_email());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result;
	}
	
	public int update(User user) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "update user_dtl set user_phone = ?, user_address = ? where user_code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_phone());
			pstmt.setString(2, user.getUser_address());
			pstmt.setInt(3, user.getUser_code());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result;
	}
	
	public int delete(int userCode) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "delete from user_mst where user_code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userCode);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result;
	}
	
	public User findUserByUserId(String userId) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			con = pool.getConnection();
			sql = "SELECT\r\n"
					+ "	um.user_code,\r\n"
					+ "	um.user_id,\r\n"
					+ "	um.user_password,\r\n"
					+ "	um.user_name,\r\n"
					+ "	um.user_email,\r\n"
					+ "	\r\n"
					+ "	ud.user_phone,\r\n"
					+ "	ud.user_address	\r\n"
					+ "FROM\r\n"
					+ "	user_mst um\r\n"
					+ "	LEFT OUTER JOIN user_dtl ud ON(ud.user_code = um.user_code)\r\n"
					+ "WHERE\r\n"
					+ "	um.user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = User.builder()
						.user_code(rs.getInt(1))
						.user_id(rs.getString(2))
						.user_password(rs.getString(3))
						.user_name(rs.getString(4))
						.user_email(rs.getString(5))
						.user_phone(rs.getString(6))
						.user_address(rs.getString(7))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
		
	}
}













