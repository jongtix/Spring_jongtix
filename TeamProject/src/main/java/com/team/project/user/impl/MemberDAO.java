package com.team.project.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.team.project.common.JDBCUtil;
import com.team.project.user.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String MEMBER_GET = "select * from pj_member where id = ? and password = ?";

	public MemberVO getMember(MemberVO vo) {
		MemberVO member = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
				member.setRrnum1(rs.getString("RRNUM1"));
				member.setRrnum2(rs.getString("RRNUM2"));
				member.setZipno(rs.getString("ZIPNO"));
				member.setAddress1(rs.getString("ADDRESS1"));
				member.setAddress2(rs.getString("ADDRESS2"));
				member.setTel1(rs.getString("TEL1"));
				member.setTel2(rs.getString("TEL2"));
				member.setTel3(rs.getString("TEL3"));
				member.setEmail(rs.getString("EMAIL"));
				member.setRegdate(rs.getDate("REGDATE"));
				member.setUse_flag(rs.getString("USE_FLAG").charAt(0));
				member.setManager_flag(rs.getString("MANAGER_FLAG").charAt(0));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return member;
	}
}
