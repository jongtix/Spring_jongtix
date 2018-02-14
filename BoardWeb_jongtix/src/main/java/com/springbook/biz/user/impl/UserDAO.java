package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDao")
public class UserDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String USER_GET = "select * from userrs where id = ? and password = ?";
	private final String USER_SET = "insert into userrs values(?, ?, ?, ?)";

	public void setUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_SET);
			int i = 0;
			pstmt.setString(++i, vo.getId());
			pstmt.setString(++i, vo.getPassword());
			pstmt.setString(++i, vo.getName());
			pstmt.setString(++i, vo.getRole());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	public UserVO getUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			int i = 0;
			pstmt.setString(++i, vo.getId());
			pstmt.setString(++i, vo.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				i = 0;
				vo.setId(rs.getString(++i));
				vo.setPassword(rs.getString(++i));
				vo.setName(rs.getString(++i));
				vo.setRole(rs.getString(++i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return vo;
	}

}
