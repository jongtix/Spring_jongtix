package com.team.project.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.team.project.board.QnaBoardVO;
import com.team.project.common.JDBCUtil;

@Repository("qnaBoardDAO")
public class QnaBoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String QNABOARD_INSERT = "insert into pj_qnaboard(num, flag, writer, subject, content, email, password, ref, ip, reg_date) "
			+ " values((select nvl(max(num), 0) + 1 from pj_qnaboard), ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

	public void insertQnaBoard(QnaBoardVO vo) {
		System.out.println("insert 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_INSERT);
			int i = 0;
			pstmt.setInt(++i, vo.getFlag());
			pstmt.setString(++i, vo.getWriter());
			pstmt.setString(++i, vo.getSubject());
			pstmt.setString(++i, vo.getContent());
			pstmt.setString(++i, vo.getEmail());
			pstmt.setString(++i, vo.getPassword());
			pstmt.setInt(++i, vo.getRef());
			pstmt.setString(++i, vo.getIp());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
}
