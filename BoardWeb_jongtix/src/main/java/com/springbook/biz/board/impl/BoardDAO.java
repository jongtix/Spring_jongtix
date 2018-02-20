package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDao")
public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String BOARD_INSERT = "insert into boardvo(seq, title, writer, content) values((select nvl(max(seq), 0) + 1 from boardvo), ?, ?, ?)";
	private final String BOARD_LIST = "select * from boardvo order by seq asc";
	private final String BOARD_UPDATE = "update boardvo set title = ?, content = ? where seq = ?";
	private final String BOARD_GET = "select * from boardvo where seq = ?";
	private final String BOARD_DELETE = "delete boardvo where seq = ?";

	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			int i = 0;
			pstmt.setString(++i, vo.getTitle());
			pstmt.setString(++i, vo.getWriter());
			pstmt.setString(++i, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				int i = 0;
				board.setSeq(rs.getInt(++i));
				board.setTitle(rs.getString(++i));
				board.setWriter(rs.getString(++i));
				board.setContent(rs.getString(++i));
				board.setRegDate(rs.getDate(++i));
				board.setCnt(rs.getInt(++i));
				list.add(board);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			int i = 0;
			pstmt.setString(++i, vo.getTitle());
			pstmt.setString(++i, vo.getContent());
			pstmt.setInt(++i, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	public BoardVO getBoard(int seq) {
		BoardVO vo = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int i = 0;
				vo.setSeq(rs.getInt(++i));
				vo.setTitle(rs.getString(++i));
				vo.setWriter(rs.getString(++i));
				vo.setContent(rs.getString(++i));
				vo.setRegDate(rs.getDate(++i));
				vo.setCnt(rs.getInt(++i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return vo;
	}

	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

}